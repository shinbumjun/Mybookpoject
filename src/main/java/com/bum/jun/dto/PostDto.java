package com.bum.jun.dto;

public class PostDto {
    
    private int num;
    private String title;
    private String writer;
    private String content;
    private String regDate; // Date 타입을 String으로 변경

    // 기본 생성자
    public PostDto() {}

    // 모든 필드를 포함하는 생성자
    public PostDto(int num, String title, String writer, String content, String regDate) {
        this.num = num;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
    }

    // Getter 및 Setter 메서드
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "PostDto [num=" + num + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate=" + regDate + "]";
    }
}
