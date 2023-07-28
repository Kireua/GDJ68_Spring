package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;

@Repository // 해당 클래스의 객체 생성
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";

	public Long getTotal(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getTotal",pager);
	}
	
	public List<BankBookDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}

	public int setAdd(BankBookDTO bankBookDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	
	public int setDelete(Long num) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete",num);
	}
	
	public int setFileAdd(BankFileDTO bankFileDTO) {
		return sqlSession.insert(NAMESPACE+"setBankFileAdd", bankFileDTO);
	}
	
	public long getSequence() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSequence");
	}
	
}
