package com.iu.main.bankBook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;

public class BankBookDAOTest extends MyTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;

	@Test
	public void addTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0; i<30; i++) {
			bankBookDTO.setBookName("서브프라임모기지"+i);
			bankBookDTO.setBookContents("서브프라임모기지론내용"+i);
			bankBookDTO.setBookRate(9.8);
			bankBookDTO.setBookSale(1);
			bankBookDAO.setAdd(bankBookDTO);
		}
		System.out.println("finish");
	}

}
