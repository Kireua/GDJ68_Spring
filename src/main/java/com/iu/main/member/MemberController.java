package com.iu.main.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="join")
	public void setJoin() throws Exception {
	
	}
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String setJoin(MemberDTO memberDTO,  MultipartFile pic,HttpSession session) throws Exception {
		int result = memberService.setJoin(memberDTO,pic,session);
		System.out.println(pic.getName());
		System.out.println(pic.getOriginalFilename());
		System.out.println(pic.getSize());
		return "redirect:../";
	}
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public void getLogin() throws Exception {
	
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String getLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO = memberService.getLogin(memberDTO);
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:../";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value="mypage")
	public String mypage() throws Exception {
		return "member/mypage";
	}
	
	@RequestMapping(value= "memberUpdate", method = RequestMethod.GET)
	public void setMemberUpdate() throws Exception{
		
	}
	
	@RequestMapping(value= "memberUpdate", method = RequestMethod.POST)
	public String setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		MemberDTO sessionMember= (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMember.getId());
		int result = memberService.setMemberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:./mypage";
	}
	
	@GetMapping(value = "idCheck")
	public String getId(MemberDTO memberDTO, Model model) throws Exception {
		memberDTO = memberService.getId(memberDTO);
		
		int result=0;
		if(memberDTO == null) {
			result=1;
		}
		model.addAttribute("result", result);
		return "commons/ajaxResult";
		
	}
	
}
