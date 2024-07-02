package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class); 
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		
		logger.info("register  GET  ");
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		logger.info("register  POST 硫붿꽌�뱶 ");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";		
	}
	
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list ...... ");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr)throws Exception {
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}	
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void modifyGET(int bno,Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("modify post");
		
		service.modify(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/listAll";
		
	}
	/*
	@RequestMapping(value="/cri", method = RequestMethod.GET)
	public void criGET(Criteria cri, Model model) throws Exception {
		model.addAttribute(service.criteria(cri));
	}
	@RequestMapping(value="/cri", method = RequestMethod.GET)
	public void criteria(Model model) throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(3);
		cri.setPerPageNum(10);
		cri.getPageStart();
		logger.info("show all list ...... ");
		model.addAttribute("cri", service.criteria(cri));
	}*/
	@RequestMapping(value="/cri", method = RequestMethod.GET)
	public void criteria(@RequestParam("page") int page,Model model) throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(10);
		cri.getPageStart();
		logger.info("show page at : "+page);
		model.addAttribute("cri", service.criteria(cri));
	}
	
	@RequestMapping(value="/cri", method = RequestMethod.POST)
	public String criPost(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("cri post");
		Criteria cri = new Criteria();
		rttr.addFlashAttribute(service.criteria(cri));
		
		return "redirect:/board/cri";
	}	
	
}
