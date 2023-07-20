package com.iu.main.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList() throws Exception {
		System.out.println("list");
		bankBookService.service();
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail",method = RequestMethod.GET) //안쓰면 기본 겟
	public ModelAndView getDetail() throws Exception {
		System.out.println("detail");
		ModelAndView mav = new ModelAndView();
		mav.addObject("num", 123);
		mav.setViewName("bankbook/detail");
		return mav;
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView setAdd(ModelAndView mav) throws Exception {
		int num =333; 
		System.out.println("add");
		mav.addObject("num", num);
		mav.setViewName("bankbook/add");
		return mav;
		
//		return "bankbook/add";
		//view의 경로명이 없으면 URL주소가 경로명으로 대체 됨
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(Model model, BankBookDTO bankBookDTO) throws Exception {
		//파라미터이름하고 변수명하고 일치하는거 찾는다.
		int num =111;
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		System.out.println(bankBookDTO.getBookSale());
		
		for(int i=0;i<bankBookDTO.getSports().length; i++) {
			System.out.println(bankBookDTO.getSports()[i]);
		}

//		BankBookDTO bankBookDTO = new BankBookDTO();
//		System.out.println(bookName);
//		System.out.println(bookSale);
//		System.out.println(book);
//		System.out.println("===================");
//		
//		bankBookDTO.setBookName(request.getParameter("bookName"));
//		bankBookDTO.setBookSale(Integer.parseInt(request.getParameter("bookSale")));
//		System.out.println(request.getParameter("bookName"));
//		System.out.println(request.getParameter("bookSale"));
//
//		String[] sports = request.getParameterValues("sports");
//		for(int i=0;i<sports.length; i++) {
//			System.out.println(sports[i]);
//		}
		model.addAttribute("num", num);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update")
	public String update() throws Exception {
		System.out.println("update");
		return "bankbook/update";
	}
	
	@RequestMapping(value="delete") //수정필요
	public String delete() throws Exception {
		System.out.println("delete");
		return "bankbook/delete";
	}
}
