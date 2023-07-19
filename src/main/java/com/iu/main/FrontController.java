package com.iu.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {
	
	//home
	// / 주소가 왔을 때 실행, index.jsp를 찾으러 가게끔
	
	 
	@RequestMapping("/")
	public String root() throws Exception {
		return "index";
	}
}
