package com.iu.main.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.board.notice.NoticeDAO;
import com.iu.main.board.notice.NoticeFileDTO;

public class NoticeDAOTEST {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() {
		NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
		
		noticeFileDTO.setFileName("karina");
		noticeFileDTO.setOriginalName("uuidkariana");
		noticeFileDTO.setNoticeNum(61L);
		
		noticeDAO.setFileAdd(noticeFileDTO);
	}

}
