package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList() throws Exception {
		System.out.println("list");
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail") //안쓰면 기본 겟
	public String getDetail(BankBookDTO bankBookDTO) throws Exception {
		bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		System.out.println("디테일까진 오냐?");
		return "bankbook/detail";
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
