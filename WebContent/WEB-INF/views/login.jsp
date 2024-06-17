<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>
   <form action="./login.do" method="post">
      <p>아 이 디 : <input type="text" name="username">
      <p>비밀번호 : <input type="text" name="password">
      <p><input type="submit" value="전송" />
   </form>
   
       <!-- 로그인 실패 메시지 표시 -->
    <c:if test="${not empty msg}">
        <p style="color: red;">${msg}</p>
    </c:if>
</body>
</html>