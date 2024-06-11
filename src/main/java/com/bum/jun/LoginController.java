package com.bum.jun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	/**
	 * �α��� �� 
	 * @return �Ź���
	 */
	@GetMapping("/login.do")
	public ModelAndView loginForm() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	} 
	
	/**
	 * �α��� 
	 * id, passwd -> 
	 * 
	 * @RequestParam("id") ���� ����
	 * 
	 * @return �Ź���
	 */
	@PostMapping("/login.do")
	public ModelAndView loginProcess(String id, String passwd) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("id : " + id);
		System.out.println("passwd : " + passwd);
		
		if(!(Logincheck(id, passwd) == 1)) {
			System.out.println("�α����� ���еǾ����ϴ�");
			mv.addObject("message", "@@@@@@@@@@@@@@@@@�α����� ���еǾ����ϴ�");
			mv.setViewName("loginResult");
			return mv;
		}
		
		System.out.println("�α����� �����Ǿ����ϴ�");
		mv.addObject("message", "@@@@@@@@@@@@@@@@@�α����� �����Ǿ����ϴ�");
		mv.setViewName("loginResult");
		
		return mv;
	}
	
	public int Logincheck(String id, String passwd) {
		if ("s123s123s".equals(id) && "1512".equals(passwd)) { // ���ڿ� �񱳴� equals
			return 1;
		}
		return -1;
	}
}



