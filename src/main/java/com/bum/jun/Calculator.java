package com.bum.jun;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {
	
	   // 데이터 주고 받기
	   @GetMapping("/useBean.do")
	   public ModelAndView process() {
		   
		   System.out.println("nnnnnnnnnnnnnnnnnnnnnnnn");
		   ModelAndView mv = new ModelAndView();
			mv.setViewName("useBean");
			
			int n = 5;
			int m = n*n*n;
			
			mv.setViewName("useBean"); // 페이지 이동
			mv.addObject("m", m); // 데이터 전송
		   
	       return mv;
	   }
	   
	}
