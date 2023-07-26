package com.iu.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		pager.makeRowNum();
		Long total = noticeDAO.getTotal();
		pager.makePageNum(total);
		return noticeDAO.getList(pager);
	}
	
	public int setAdd(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.setAdd(noticeDTO);
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.setDelete(noticeDTO);
	}
	
	public int setHitCount(NoticeDTO noticeDTO) throws Exception {
		
		return noticeDAO.setHitCount(noticeDTO);
	}
	
}
