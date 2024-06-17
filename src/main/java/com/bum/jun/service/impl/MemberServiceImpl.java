package com.bum.jun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bum.jun.dao.MemberDao;
import com.bum.jun.dto.UserDto;
import com.bum.jun.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mDao; 
	
	@Override
	public int signup(UserDto userdto) { // 회원가입
		
		System.out.println("회원가입 : " + userdto);
		int cnt = mDao.select();
		System.out.println("SQL문이 잘 돌아갔는지 확인 : " + cnt);
		return cnt;
	}
}
