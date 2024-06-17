package com.bum.jun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bum.jun.dao.MemberDao;
import com.bum.jun.dto.UserDto;
import com.bum.jun.service.MemberService;
import com.bum.jun.util.Sha512Encoder;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mDao; 
	
	@Override
	public int signup(UserDto userdto) { // 회원가입
		
		// UserDTO [userId=0, username=s123s123s, password=123, name=신범준, phone=010-3873-6180, 
		//          sex=남성, hobby=독서, email=sinbumjun123@naver.com, regDate=null]
		System.out.println("회원가입 : " + userdto);
		
		// *비밀번호 암호화
		Sha512Encoder encoder = Sha512Encoder.getInstance(); // 1. SHA-512 암호화를 위한 인스턴스를 얻는다
		System.out.println("encoder : " + encoder); // com.feb.test.util.Sha512Encoder@7c3a98fc
		
		String passwd = userdto.getPassword(); // 2. 브라우저에서 입력한 비밀번호
		System.out.println("userdto.getPassword() : " + userdto.getPassword()); // 123
		
		String encodeTxt = encoder.getSecurePassword(passwd); // 3. 비밀번호 암호화
		System.out.println("userPw : " + encodeTxt); // 3c9909afec25354d551dae21590...
		
		userdto.setPassword(encodeTxt); // 4. 암호화한 패쓰워드로 저장
		
		int cnt = mDao.signup(userdto);
		System.out.println("SQL문이 잘 돌아갔는지 확인 : " + cnt);
		return cnt;
	}
}
