package com.bum.jun.dao;

import org.springframework.stereotype.Repository;

import com.bum.jun.dto.UserDto;

public interface MemberDao {

	// 회원가입
	public int signup(UserDto userdto);

}
