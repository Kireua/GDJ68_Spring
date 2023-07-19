package com.iu.main.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping(value="join")
	public String join() throws Exception {
		System.out.println("join");
		return "member/join";
	}
	
	@RequestMapping(value="login")
	public String login() throws Exception {
		System.out.println("login");
		return "member/login";
	}
	
	@RequestMapping(value="logout")
	public String logout() throws Exception {
		System.out.println("logout");
		return "member/logut";
	}
	
	@RequestMapping(value="mypage")
	public String mypage() throws Exception {
		System.out.println("mypage");
		return "member/mypage";
	}
}
