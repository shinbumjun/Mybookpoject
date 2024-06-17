package com.bum.jun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bum.jun.dto.UserDto;
import com.bum.jun.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService lService;
	
	/**
	 * 로그인 폼 
	 * @return 신범준
	 * username -> username
	 * password -> password
	 */
	@GetMapping("/login.do")
	public ModelAndView loginForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	} 
	
	/**
	 *  북 페이지로
	 * @return 신범준
	 */
	@GetMapping("/addBook.do")
	public ModelAndView addBook() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addBook");
		
		return mv;
	} 
	
	
	
	/**
	 * 로그인하기
	 * id, passwd -> 
	 * 
	 * @RequestParam("id") 생략 가능
	 * 
	 * username -> username
	 * password -> password
	 * 
	 * @return 신범준
	 */
	@PostMapping("/login.do")
	public ModelAndView loginProcess(UserDto userdto) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("로그인 : " + userdto);
		
		if(!(Logincheck(userdto) == true)) {
			mv.addObject("success", "-1");
			mv.addObject("msg", "로그인에 실패했습니다");
			mv.setViewName("login");
			return mv;
		}
		mv.addObject("success", "1");
		mv.addObject("msg", "로그인 성공했습니다");
		mv.setViewName("board");
		
		return mv;
	}
	
	private boolean Logincheck(UserDto userdto) {
		boolean cnt = lService.Logincheck(userdto);
		System.out.println("아이디와 비밀번호가 일치하는가 : " + cnt);
		return cnt;
	}

}



