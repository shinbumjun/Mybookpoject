package com.bum.jun.dto;

public class UserDto {
	
    private int userId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String sex; // 성별을 나타내는 문자열
    private String hobby; // 취미를 나타내는 문자열
    private String email;
    private String regDate;
    
    public UserDto() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", sex=" + sex + ", hobby=" + hobby + ", email=" + email + ", regDate=" + regDate
				+ "]";
	}
}
