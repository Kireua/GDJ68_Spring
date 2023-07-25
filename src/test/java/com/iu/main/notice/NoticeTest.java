package com.iu.main.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;

public class NoticeTest extends MyTest{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getListTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.getList();
		
		assertNotEquals(0,ar.size());
	}


}
