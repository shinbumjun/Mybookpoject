<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>File Upload Result</title>
</head>
<body>
    <h1>파일 업로드 결과</h1>
    
    <p>이름: ${file.name}</p>
    <p>제목: ${file.subject}</p>
    <p>파일 이름: ${file.filename.originalFilename}</p>
    <p>파일 크기: ${file.filename.size} bytes</p>
    <p>파일 타입: ${file.filename.contentType}</p>
    
    <a href="./fileupload01.do">파일 업로드 다시 하기</a>
    <a href="./index.do">홈으로 가기</a>
</body>
</html>
