package com.iu.main.bankAccount;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.member.MemberDTO;

@Repository
public class BankAccountDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.main.bankAccount.BankAccountDAO.";
	
	public long getTotal() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotal");
	}
	
	public List<BankAccountDTO> getList(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	
	public int setAdd(BankAccountDTO bankAccountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", bankAccountDTO);
	}
}
