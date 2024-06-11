package com.dto;

import org.springframework.web.multipart.MultipartFile;

public class Fileupload {

	 //name, subject, filename
	private String name; // 이름
	private String subject; // 제목 
	private MultipartFile filename;  // 파일 업로드를 처리하는 MultipartFile 필드
	
	public Fileupload() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "Fileupload [name=" + name + ", subject=" + subject + ", filename=" + filename + "]";
	}

}
