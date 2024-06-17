package com.bum.jun.service;

import com.bum.jun.dto.UserDto;

public interface MemberService {
	
	// 회원가입
	int signup(UserDto userdto);
}
