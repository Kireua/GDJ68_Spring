package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		List<BankBookDTO> ar = bankBookService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail") //안쓰면 기본 겟
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mav) throws Exception {
		bankBookDTO=bankBookService.getDetail(bankBookDTO);
		mav.addObject("dto",bankBookDTO);
		mav.setViewName("bankbook/detail");
		return mav;
	}
	
	@RequestMapping(value="add")
	public void setAdd() throws Exception {
		
	}
	
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setAdd(bankBookDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update")
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="delete") //수정필요
	public String delete(Long bookNum) throws Exception {
		bankBookService.setDelete(bookNum);
		return "redirect:./list";
	}
}
