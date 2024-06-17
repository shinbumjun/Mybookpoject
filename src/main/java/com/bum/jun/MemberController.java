package com.bum.jun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bum.jun.dto.UserDto;
import com.bum.jun.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	/**
	 * 회원가입 폼
	 * @return 신범준
	 */
	@GetMapping("/form01.do")
	public ModelAndView loginForm1() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form01");
		
		return mv;
	} 
	
	/**
	 * 회원가입
	 * username
	 * password
	 * name
	 * phone1, phone2, phone3 -> phone
	 * sex
	 * hobby
	 * email
	 * @return 신범준
	 */
	@PostMapping("/signup.do")
	public ModelAndView signup(@ModelAttribute UserDto userdto, 
							   @RequestParam String phone1, 
							   @RequestParam String phone2,  
							   @RequestParam String phone3) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("전화번호: " + phone1 +"-"+ phone2 +"-"+ phone3); // 전화번호: 010-3873-6180
	    String phone = phone1 + "-" + phone2 + "-" + phone3; // 전화번호 합치기
	    userdto.setPhone(phone); // UserDTO에 전화번호 설정
		System.out.println("회원가입 정보 : " + userdto);
		// UserDTO [userId=0, username=s123s123s, password=123, name=신범준, phone=010-3873-6180, 
		//          sex=남성, hobby=독서,운동, email=sinbumjun123@naver.com, regDate=null]
		
		int cnt = mService.signup(userdto);
		System.out.println("회원가입이 되었는지 확인 : " + cnt);
		
		mv.setViewName("board");
		
		return mv;
	} 
}