<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">

</head>
<body>

	<table>
		<tr>
          <td colspan="5">
            <h3>게시글 제목 클릭시 상세 열람 가능</h3>
          </td>
        </tr>
        <tr>
        <td colspan="5">
            <button type="button" value="신규 글 작성" onClick="location.href='./writePost.do'">신규 글 작성</button>
          </td>
        </tr>
        <tr>
          <td>번호</td>
          <td>작성자</td>
          <td>제목</td>
          <td>작성일</td>
          <td>관리</td>
        </tr>
        
                <c:forEach var="post" items="${postList}">
		            <tr>
		                <td>${post.num}</td>
		                <td>${post.writer}</td>
		                <td><a href="readPost.do?num=${post.num}">${post.title}</a></td>
		                <td>${post.regDate}</td>
		                <td>
		                    <a href="editPost.do?num=${post.num}">수정</a> | 
		                    <a href="deletePost.do?num=${post.num}">삭제</a>
		                </td>
		            </tr>
		        </c:forEach>
        
    </table>
    
</body>
</html>


