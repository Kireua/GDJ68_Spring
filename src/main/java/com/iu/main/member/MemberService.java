package com.iu.main.member;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
//	@Autowired
//	private HttpSession session; // 이렇게하면 나중에 문제 생길 수 있음  
	
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.setMemberUpdate(memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO, MultipartFile pic,HttpSession session) throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
		
		// 1. 어디에 저장
		String path = "/resources/upload/member";
		
		//2. 실제 경로 알아오기
		// jsp : application 이라 부름
		// java : ServletContext 라 부름 둘이 같은 말
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		Calendar ca = Calendar.getInstance();
		long result = ca.getTimeInMillis();
		
		file = new File(file,result+"_"+pic.getOriginalFilename());
		//4. 파일을 저장
		//A. Spring에서 제공하는 API FileCopyUtils의 copy메서드
//		FileCopyUtils.copy(pic.getBytes(), file);
		
		//B. MultipartFile의 transferTo 메서드
		pic.transferTo(file);
//		return memberDAO.setJoin(memberDTO);
		return 0;
	}
}
