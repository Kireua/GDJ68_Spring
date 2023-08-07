package com.iu.main.bankAccount;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public List<BankAccountDTO> getList(MemberDTO memberDTO, Pager pager) throws Exception {
		pager.setPerPage(3L);
		pager.makeRowNum();
		
		pager.makePageNum(bankAccountDAO.getTotal());
		// mapper에서 memberDTO하면 pager의 멤버변수인 startRow 등의 변수를 못씀 그래서 둘을 한번에 담는 map을 사용
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", memberDTO);
		map.put("pager", pager);
		return bankAccountDAO.getList(map);
	}
	
	public int setAdd(BankAccountDTO bankAccountDTO) throws Exception {
		Calendar ca = Calendar.getInstance();
		bankAccountDTO.setAccount(ca.getTimeInMillis());
		return bankAccountDAO.setAdd(bankAccountDTO);
		
	}
}


