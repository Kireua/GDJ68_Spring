package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnAController {

	@Autowired
	private QnAService qnAService;
	

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		List<BoardDTO> ar = qnAService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(QnADTO qnADTO, MultipartFile[] photos, HttpSession session) throws Exception {
		
		int result = qnAService.setAdd(qnADTO, photos, session);
		return "redirect:./list";
	}
	
}
