package com.iu.main.bankBook;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.qna.QnADTO;

public class BankBookDAOTest extends MyTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private QnADTO qnADTO

	@Test
	public void getListTest() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("startRow", 1);
		map.put("lastRow", 10);
		
		List<BankBookDTO> ar = bankBookDAO.getList(map);
		System.out.println(ar.get(0).getBookNum());
		System.out.println(ar.get(9).getBookNum());
	}
	
//	@Test
	public void addTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0; i<30; i++) {
//			bankBookDTO.setBookName("서브프라임모기지"+i);
//			bankBookDTO.setBookContents("서브프라임모기지론내용"+i);
//			bankBookDTO.setBookRate(9.8);
//			bankBookDTO.setBookSale(1);
//			bankBookDAO.setAdd(bankBookDTO);
		}
		System.out.println("finish");
	}

}
