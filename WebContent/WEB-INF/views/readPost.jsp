<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <h2>게시글 상세 보기</h2>
    <table>
        <tr>
            <td>번호</td>
            <td>${read.num}</td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>${read.writer}</td>
        </tr>
        <tr>
            <td>제목</td>
            <td>${read.title}</td>
        </tr>
        <tr>
            <td>작성일</td>
            <td>${read.regDate}</td>
        </tr>
        <tr>
            <td>내용</td>
            <td>${read.content}</td>
        </tr>
    </table>
    <a href="./boardList.do">목록으로 돌아가기</a>
</body>
</html>
