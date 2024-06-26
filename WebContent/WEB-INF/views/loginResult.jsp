<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>
	<p>id와 password를 가져왔습니다</p>

   <%
      request.setCharacterEncoding("utf-8");
      String userid = request.getParameter("id");
      // 둘 다 HTTP 요청으로부터 데이터를 가져오는 데 사용되지만, 그 데이터의 출처와 사용하는 방식에 차이가 있습니다
      // 예) 사용자가 로그인 폼을 제출할 때 입력한 값
      String password = request.getParameter("passwd");
      // 이 메서드는 서블릿이나 다른 서버 측 코드에서 설정한 속성을 가져옵니다, Object (형변환 필요)
      String message = (String) request.getAttribute("message");
      String success = (String) request.getAttribute("success");
   %>
   <p>아이디 : <%=userid%>
   <p>비밀번호 : <%=password%>
   <p><%=message%></p>
   
   <% if ("1".equals(success)) { %>
   		<p>로그인 했을때만 보이는 태그 >>>>> <a href="./books.do">북으로 이동</a></p>
   		<p>북 추가하는 태그 >>>>> <a href="./addBook.do">북 추가하기 위해서 이동</a></p>
   <% }else{ %>
   		<p>로그인에 실패하였습니다. 다시 시도하려면 <a href="./login.do">여기</a>를 클릭하세요.</p>
   <% } %>
   		
    <%
       request.setCharacterEncoding("utf-8");
       String name = request.getParameter("name");
   	%>
   	<br>
    <p>
	        아이디 : <%= userid%><br>
	        요청 정보 길이 : <%= request.getContentLength()%><br>
	        클라이언트 전송 방식 : <%= request.getMethod()%><br>
	        요청 URI : <%= request.getRequestURI()%><br>
	        서버 이름 : <%=request.getServerName()%><br>
	        서버 포트 : <%=request.getServerPort()%><br>
    </p>    
    <br>
    <a href="./index.do">홈으로 가기</a>
</body>
</html>




