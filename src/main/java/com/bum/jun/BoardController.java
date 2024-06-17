package com.bum.jun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	/**
	 * 게시판 이동
	 * @return 신범준
	 */
	@GetMapping("/board.do")
	public ModelAndView board() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board");
		
		return mv;
	} 
	
	/**
	 * 게시글 이동
	 * @return 신범준
	 */
	@GetMapping("/boardList.do")
	public ModelAndView boardList() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardList");
		
		return mv;
	} 
	
	
	
	
}
