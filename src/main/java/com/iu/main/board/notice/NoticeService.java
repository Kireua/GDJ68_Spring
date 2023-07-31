package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankBook.BankFileDTO;
import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRowNum();
		Long total = noticeDAO.getTotal(pager);
		pager.makePageNum(total);
		return noticeDAO.getList(pager);
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] photos, HttpSession session) throws Exception {
		String path = "/resources/upload/notice/";
		//1번째방법 쿼리만들고 dao 만들어서 하기
//		long num = bankBookDAO.getSequence();
//		bankBookDTO.setBookNum(num);
		int result = noticeDAO.setAdd(boardDTO);
		
		for(MultipartFile multipartFile: photos) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(path, multipartFile,session);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			//2번째 방법 selectkey 매퍼 에서 등록해서 사용하기
			noticeFileDTO.setNoticeNum(boardDTO.getNum());
			result = noticeDAO.setFileAdd(noticeFileDTO);
		}
		
		return result ;
	}
	
	@Override
	public NoticeDTO getDetail(BoardDTO boardDTO) throws Exception {
		int result = noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getDetail(boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setUpdate(boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setDelete(boardDTO);
	}
	

	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setHitUpdate(boardDTO);
	}
	
}
