package com.iu.main.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class QnAService {

	@Autowired
	private QnADAO qnADAO;
	
	public List<QnADTO> getList(Pager pager) throws Exception {
		
		pager.makeRowNum();
		Long total = qnADAO.getTotal(pager);
		pager.makePageNum(total);
		return qnADAO.getList(pager);
	}
}
