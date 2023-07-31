package com.iu.main.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;

@Repository
public class QnADAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.qna.QnADAO.";

	public Long getTotal(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getTotal",pager);
	}
	
	public List<QnADTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
} 
