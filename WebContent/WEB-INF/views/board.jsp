<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 연습 메인 화면</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <h1>게시판 연습 메인화면입니다</h1>

    <%-- 회원가입 성공 또는 실패 메시지 출력 --%>
    <c:if test="${not empty msg}">
        <p>${msg}</p>
    </c:if>

    <button class="btn" type="button" onclick="location.href='./boardList.do'">
        <h3>글 목록 바로가기</h3>
    </button>

    <%-- 로그인 페이지로 이동하는 링크 --%>
    <a href="./index.do">홈으로 이동</a>

</body>
</html>
