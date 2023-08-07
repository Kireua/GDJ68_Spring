package com.iu.main.bankAccount;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bankAccount/*")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	
	@GetMapping(value = "list")
	public ModelAndView getList(HttpSession session, Pager pager, ModelAndView mav) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<BankAccountDTO> ar = bankAccountService.getList(memberDTO, pager);
		mav.addObject("list", ar);
		mav.addObject("pager", pager);
		mav.setViewName("bankAccount/list");
		
		return mav;
	}
	
	@GetMapping(value = "add")
	public void setAdd(BankAccountDTO bankAccountDTO, Model model) throws Exception{
		model.addAttribute("dto", bankAccountDTO);
	}
	
	@PostMapping(value = "add")
	public String setAdd(BankAccountDTO bankAccountDTO, HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		bankAccountDTO.setId(memberDTO.getId());
		int result = bankAccountService.setAdd(bankAccountDTO);
		
//		String message="상품가입이 실패";
//		
//		if(result>0) {
//			message="상품가입이 완료";
//		}
//		model.addAttribute("message", message);
//		model.addAttribute("url", "../");
		
		model.addAttribute("result", result);
		return "commons/ajaxResult";
		
	}
	
}
