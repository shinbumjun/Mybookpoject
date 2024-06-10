package com.bum.jun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

		public IndexController() {
			System.out.println("111111111111111111111111111");
		}

		// 홈 페이지
		@GetMapping("/index.do")
		public ModelAndView loginForm() {
			
			System.out.println("222222222222222222222222222222");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index");
			
			return mv;
		}
		
}
