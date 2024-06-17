package com.bum.jun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.bum.jun.dao.LoginDao;
import com.bum.jun.dto.UserDto;
import com.bum.jun.service.LoginService;
import com.bum.jun.util.Sha512Encoder;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao LDao;
	
	@Override // 로그인 체크
	public boolean Logincheck(UserDto userdto) {
		System.out.println("로그인 : " + userdto);
		UserDto cnt = LDao.Logincheck(userdto.getUsername());
		
		// UserDTO [userId=6, username=s123s123s, password=3c9909afec25354d551da...
		System.out.println("로그인 정보 : " + cnt);

		if(ObjectUtils.isEmpty(userdto.getUsername())) { // null이면 true 반환
			return false;
		}
		
		// 2. 비밀번호 비교
		String passwd = userdto.getPassword(); // 사용자가 입력한 비밀번호
		System.out.println("사용자가 입력한 비밀번호 : " + passwd); // 123
		
		String memberPw = cnt.getPassword(); // DB에 저장되어 있는 암호화 된 비밀번호 
		System.out.println("DB에 저장되어 있는 암호화 된 비밀번호  : " + memberPw); // 3c9909afec25354...
		
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		System.out.println("encoder  : " + encoder); // com.lhs.util.Sha...
		
		String encodeTxt = encoder.getSecurePassword(passwd); // 사용자가 입력한 값을 암호화한 거다 
		System.out.println("사용자가 입력한 값을 암호화한 거다  : " + encodeTxt);	 // 3c9909afec25354...
		
		return StringUtils.pathEquals(memberPw, encodeTxt); // 비교해서 틀리면 false반환
	}

}
