package com.iu.main.comment.bankComment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.bankAccount.BankAccountDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bankComment/*")
public class BankCommentController {
	
	@Autowired
	private BankCommentService bankCommentService;
	
	
//	@GetMapping(value = "add")
//	public void setAdd(BankCommentDTO bankCommentDTO,Model model) throws Exception {
//		model.addAttribute("dto", bankCommentDTO);
//	}
	
	@PostMapping(value = "add")
	public String setAdd(BankCommentDTO bankCommentDTO,Model model) throws Exception {
		
		int result = bankCommentService.setAdd(bankCommentDTO);
		
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
	
	@GetMapping(value = "list")
	public ModelAndView getList(BankCommentDTO bankCommentDTO,Pager pager, ModelAndView mav) throws Exception {
		System.out.println(bankCommentDTO.getBookNum());
		List<BankCommentDTO> ar = bankCommentService.getList(bankCommentDTO,pager);
		mav.addObject("list", ar);
		mav.addObject("pager", pager);
		mav.setViewName("bankComment/list");
		
		return mav;
	}

}
