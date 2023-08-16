package com.iu.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.main.file.FileDTO;

@Component
public class FileManager extends AbstractView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("FileManager");
		String b = (String) model.get("board");
		System.out.println(b);
		FileDTO fileDTO = (FileDTO)model.get("file");
		//1. 파일 경로 준비 
		String path = "/resources/upload/"+b;
		path = request.getSession().getServletContext().getRealPath(path);
		
		//2. File 객체 생성
		File file = new File(path,fileDTO.getFileName());
		
		//3. 총 파일 크기
		response.setContentLength((int)file.length());
		
		//4. 파일이름 지정 및 인코딩 설정
		String downName = fileDTO.getOriginalName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
		//5. 헤더 정보
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		
		//6. 전송 input = 서버로 읽어와라 정보들을
		FileInputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(is, os);
		
		//7. 자원 해제
		os.close();
		is.close();
	}
	
	
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
		System.out.println(realPath);
		return uId;
	}
	
	public boolean fileDelete(FileDTO fileDTO,String path,HttpSession session) throws Exception {
		//1. 삭제할 폴더의 실제 경로
		path = session.getServletContext().getRealPath(path);
		
		File file = new File(path, fileDTO.getFileName());
	
		return file.delete();
	}

}
