<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>홈 페이지</h2>
	<hr>
	<p>좋은 하루에요~ 오늘 날짜는 <%=java.time.LocalDateTime.now() %> 입니다</p>
	<hr>
	<h2>scripting tag</h2>
	<!-- JSP 페이지의 선언부에 변수를 선언하거나 메서드를 정의할 때 사용 -->
	<%! 
		int count=3; 
		String makeItLower(String data){ return data.toLowerCase(); } 
	%>
	<!-- JSP 페이지의 특정 위치에서 자바 코드를 실행할 때 사용 -->
	<%
		for(int i=1; i<= count; i++){
			out.println("Java Server Pages " + i + " <br>");
		}
	%>
	<!-- JSP 페이지에 자바 표현식을 삽입하고 그 결과를 출력할 때 사용 -->
	<%= makeItLower("Hello World") %>
	<hr>
	<p>Today's date: <%=new java.util.Date() %></p>
	<hr>
	<%
		int a=10;
		int b=20;
		int c=30;
	%>
	<%= a+b+c %>
</body>
</html>



