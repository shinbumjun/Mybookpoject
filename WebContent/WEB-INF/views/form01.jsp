<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Form Processing</title>
</head>
<body>
   <h3>회원가입</h3>
   <form action="./signup.do" name="member" method="post">
      <p>아이디 : <input type="text" name="username"> 
          <input type="button" value="아이디 중복검사">
      </p>
      
      <p>비밀번호 : <input type="password" name="password"></p>
      
      <p>이름 : <input type="text" name="name"></p>
      
      <p>연락처 : <input type="text" maxlength="4" size="4" name="phone1">
           - <input type="text" maxlength="4" size="4" name="phone2">
           - <input type="text" maxlength="4" size="4" name="phone3">
      </p>
      
      <p>성별 : <input type="radio" name="sex" value="남성" checked>남성 
          <input type="radio" name="sex" value="여성">여성
      </p>
      
      <p>취미 : 
          <label><input type="checkbox" name="hobby" value="독서" checked>독서</label>
          <label><input type="checkbox" name="hobby" value="운동">운동</label>
          <label><input type="checkbox" name="hobby" value="영화">영화</label>
      </p>
      
      <p>이메일 : <input type="email" name="email"></p>
      
      <p><input type="submit" value="가입하기"> 
         <input type="reset" value="다시쓰기">
      </p>
   </form>
   <a href="./login.do">로그인</a>
</body>
</html>
