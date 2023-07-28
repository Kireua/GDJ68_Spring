package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getList(Pager pager) throws Exception {
//		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//page			startRow 			lastRow
		// 1				1				  10
		// 2				11				  20
		// 3				21			      30
//		int count=10;
//		String s = (page-1)+"1";
//		int startRow = Integer.parseInt(s);
//		int startRow = (page-1)*count+1;
//		
//		int lastRow = page*count;
//		map.put("lastRow", lastRow);
//		map.put("startRow", startRow);
		pager.makeRowNum();
		Long total = bankBookDAO.getTotal(pager);
		pager.makePageNum(total);
		return bankBookDAO.getList(pager);
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setAdd(BankBookDTO bankBookDTO, MultipartFile[] photos, HttpSession session) throws Exception {
		String path = "/resources/upload/bankBook/";
		//1번째방법 쿼리만들고 dao 만들어서 하기
//		long num = bankBookDAO.getSequence();
//		bankBookDTO.setBookNum(num);
		int result = bankBookDAO.setAdd(bankBookDTO);
		
		for(MultipartFile multipartFile: photos) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, multipartFile,session);
			BankFileDTO bankFileDTO = new BankFileDTO();
			bankFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			bankFileDTO.setFileName(fileName);
			//2번째 방법 selectkey 매퍼 에서 등록해서 사용하기
			bankFileDTO.setBookNum(bankBookDTO.getBookNum());
			result = bankBookDAO.setFileAdd(bankFileDTO);
		}
		
		
		
		
		
		return result ;
	}

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(Long num) throws Exception{
		return bankBookDAO.setDelete(num);
	}
}
