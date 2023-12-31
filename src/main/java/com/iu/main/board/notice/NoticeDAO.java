package com.iu.main.board.notice;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.bankBook.BankFileDTO;
import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.iu.main.board.notice.NoticeDAO.";
	
	@Override
	public Long getTotal(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotal",pager);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setAdd",boardDTO);
	}
	
	@Override
	public NoticeDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
	
		return sqlSession.delete(NAMESPACE+"setDelete",boardDTO);
		
	}
	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"setHitCount", boardDTO);
	}

	public int setFileAdd(NoticeFileDTO noticeFileDTO) {
		return sqlSession.insert(NAMESPACE+"setFileAdd", noticeFileDTO);
	}
	
	public int setFileDelete(NoticeFileDTO noticeFileDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setFileDelete",noticeFileDTO);
	}
	
	public NoticeFileDTO getFileDetail(NoticeFileDTO noticeFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getFileDetail", noticeFileDTO);
	}
}
