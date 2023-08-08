package com.iu.main.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private FileManager fileManager;
//	@Autowired
//	private HttpSession session; // 이렇게하면 나중에 문제 생길 수 있음  
	
	
	public MemberDTO getId(MemberDTO memberDTO) throws Exception {
		return memberDAO.getId(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.setMemberUpdate(memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO, MultipartFile pic,HttpSession session) throws Exception{
		String path = "/resources/upload/member/";
		
		int result = memberDAO.setJoin(memberDTO);
		
		if(!pic.isEmpty()) {
			
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setOriginalName(pic.getOriginalFilename());
			memberFileDTO.setFileName(fileManager.fileSave(path, pic, session));
			result = memberDAO.setFileJoin(memberFileDTO);
			
		}
		
		// 1. 어디에 저장
		
		
		
		
		//2. 실제 경로 알아오기
		// jsp : application 이라 부름
		// java : ServletContext 라 부름 둘이 같은 말
//		String realPath = session.getServletContext().getRealPath(path);
//		System.out.println(realPath);
//		File file = new File(realPath);
//		if(!file.exists()) {
//			file.mkdirs();
//		}
//		//1. calendar 사용
////		Calendar ca = Calendar.getInstance();
////		long result = ca.getTimeInMillis();
////		file = new File(file,result+"_"+pic.getOriginalFilename());
//	
//		//2. API 사용
//		String uId = UUID.randomUUID().toString();
//		System.out.println(uId);
//		file = new File(file, uId+"_"+pic.getOriginalFilename());
//		//4. 파일을 저장
//		//A. Spring에서 제공하는 API FileCopyUtils의 copy메서드
////		FileCopyUtils.copy(pic.getBytes(), file);
//		
//		//B. MultipartFile의 transferTo 메서드
//		pic.transferTo(file);
//		return memberDAO.setJoin(memberDTO);
		return result;
	}
}
