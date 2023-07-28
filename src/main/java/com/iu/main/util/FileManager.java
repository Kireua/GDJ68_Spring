package com.iu.main.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//fileSave
	public String fileSave(String path,MultipartFile pic,HttpSession session) throws Exception{
		//path에 각 서비스에서 경로 지정
		
		//realPath 경로를 애플리케이션 에서 가져오기 애플리케이션에서 가져오기위해 세션객체를 사용
	
		String realPath = session.getServletContext().getRealPath(path);
		//file 로 real path경로 있는지 없는지 여부 확인 없다면 mkdirs메서드로 생성
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//파일이름 중복되면 안되기때문에 UUID를 이용하여 랜덤 이름 생성
		String uId = UUID.randomUUID().toString();
		uId = uId+"_"+pic.getOriginalFilename();
		file = new File(file, uId);
		pic.transferTo(file);
		return uId;
	}

}
