package com.iu.main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iu.main.bankBook.BankBookDAO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class MyTest {

//	@Autowired
//	private BankBookDAO bankBookDAO;
//	
//	@Test
//	public void deleteTest() throws Exception {
//		int result = bankBookDAO.setDelete(82L);
//		
//		assertNotEquals(0, result);
//	}

}
