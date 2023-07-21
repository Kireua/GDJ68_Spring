package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail") //안쓰면 기본 겟
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mav) throws Exception {
		bankBookDTO=bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		System.out.println("디테일은 오냐?");
		mav.addObject("dto",bankBookDTO);
		mav.setViewName("bankbook/detail");
		return mav;
	}
	
	@RequestMapping(value="add")
	public String add() throws Exception {
		System.out.println("add");
		return "bankbook/add";
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
