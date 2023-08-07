package com.iu.main.bankAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.member.MemberDTO;

public class BankAccountDAOTest extends MyTest {

	@Autowired
	private BankAccountDAO dao;
	
//	@Test
//	public void getListTest() throws Exception {
//
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("seo");
//		List<BankAccountDTO> ar = dao.getList(memberDTO);
//		
//		assertEquals(0,ar.size());
//	}
	
	@Test
	public void setAddTest() throws Exception {
		BankAccountDTO dto = new BankAccountDTO();
		dto.setId("seo");
		dto.setBookNum(172L);
		dto.setAccount(123456L);
		dto.setBalance(100000000L);
		dto.setAccountPw("0000");
		
		int result = dao.setAdd(dto);
		assertEquals(1, result);
		
	}

}
