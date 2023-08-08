package com.iu.main.comment.bankComment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankCommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.main.comment.bankComment.BankCommentDAO.";
	
	public int setAdd(BankCommentDTO bankCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", bankCommentDTO);
	}
	
	public List<BankCommentDTO> getList(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	
	public Long getTotal(BankCommentDTO bankCommentDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotal",bankCommentDTO);
	}
}
