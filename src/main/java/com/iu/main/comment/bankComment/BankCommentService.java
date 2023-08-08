package com.iu.main.comment.bankComment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class BankCommentService {

	@Autowired
	private BankCommentDAO bankCommentDAO;
	
	public int setAdd(BankCommentDTO bankCommentDTO) throws Exception {
		return bankCommentDAO.setAdd(bankCommentDTO);
	}
	
	public List<BankCommentDTO> getList(BankCommentDTO bankCommentDTO,Pager pager) throws Exception {
		pager.setPerPage(3L);
		pager.makeRowNum();
		
		pager.makePageNum(bankCommentDAO.getTotal(bankCommentDTO));
		// mapper에서 memberDTO하면 pager의 멤버변수인 startRow 등의 변수를 못씀 그래서 둘을 한번에 담는 map을 사용
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookNum", bankCommentDTO);
		map.put("pager", pager);
		return bankCommentDAO.getList(map);
	}
}
