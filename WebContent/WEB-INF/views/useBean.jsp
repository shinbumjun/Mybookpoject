<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	   <!-- jsp:useBean id="bean" class="com.bum.jun.Calculator" / -->
	    <%
	        // Controller에서 전달된 'm' 값을 가져옵니다.
	        int m = (Integer) request.getAttribute("m");
	        out.print("컨트롤러에서 데이터 전달 받음 5의 3제곱 : " + m);
	    %>
	    
	   <a href="./login.do">로그인</a>
	   <a href="./form01.do">회원가입</a>
	   <a href="./Fileupload01.do">파일 업로드</a>
	   <a href="./board.do">게시판</a>

</body>
</html>