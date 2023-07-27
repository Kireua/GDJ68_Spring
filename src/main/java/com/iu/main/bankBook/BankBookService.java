package com.iu.main.bankBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
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
	
	public int setAdd(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setAdd(bankBookDTO);
	}

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(Long num) throws Exception{
		return bankBookDAO.setDelete(num);
	}
}
