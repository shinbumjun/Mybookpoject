package com.bum.jun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	/**
	 * 로그인 폼 
	 * @return 신범준
	 */
	@GetMapping("/login.do")
	public ModelAndView loginForm() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	} 
	
	/**
	 * 로그인 
	 * id, passwd -> 
	 * 
	 * @RequestParam("id") 생략 가능
	 * 
	 * @return 신범준
	 */
	@PostMapping("/login.do")
	public ModelAndView loginProcess(String id, String passwd) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("id : " + id);
		System.out.println("passwd : " + passwd);
		
		if(!(Logincheck(id, passwd) == 1)) {
			System.out.println("로그인이 실패되었습니다");
			mv.addObject("message", "@@@@@@@@@@@@@@@@@로그인이 실패되었습니다");
			mv.setViewName("loginResult");
			return mv;
		}
		
		System.out.println("로그인이 성공되었습니다");
		mv.addObject("message", "@@@@@@@@@@@@@@@@@로그인이 성공되었습니다");
		mv.setViewName("loginResult");
		
		return mv;
	}
	
	public int Logincheck(String id, String passwd) {
		if ("s123s123s".equals(id) && "1512".equals(passwd)) { // 문자열 비교는 equals
			return 1;
		}
		return -1;
	}
}



