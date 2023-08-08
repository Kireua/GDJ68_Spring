package com.iu.main.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.member.MemberDAO.";
	
	public int setFileJoin(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileJoin", memberFileDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getLogin",memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
	public MemberDTO getId(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getId", memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO) {
		return sqlSession.insert(NAMESPACE + "setJoin", memberDTO);
	}
}
