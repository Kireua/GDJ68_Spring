package com.iu.main.board.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.board.BoardDTO;

public class QnADAOTest extends MyTest {

	@Autowired
	QnADAO qnADAO = new QnADAO();
	
	@Test
	public void test() throws Exception {
		QnADTO boardDTO = new QnADTO();
		boardDTO.setName("seo");
		boardDTO.setSubject("testtest13");
		boardDTO.setContents("그냥테스트");
		
		
		int result = qnADAO.setAdd(boardDTO);
		assertEquals(1, result);
	}

}
