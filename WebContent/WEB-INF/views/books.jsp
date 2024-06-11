<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>
    <h1>도서 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>도서 ID</th>
                <th>도서명</th>
                <th>저자</th>
                <th>출판사</th>
                <th>가격</th>
                <th>설명</th>
                <th>출판일</th>
            </tr>
        </thead>
        <tbody>
            <!-- 도서 목록을 반복하면서 테이블에 출력 -->
            <c:forEach items="${listOfBooks}" var="book">
                <tr>
                    <td>${book.bookId}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.publisher}</td>
                    <td>${book.unitPrice}</td>
                    <td>${book.description}</td>
                    <td>${book.releaseDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="./books.do">도서 목록으로 돌아가기</a>
    <a href="./index.do">홈으로 돌아가기</a>
    <a href="./login.do">로그인</a>
</body>
</html>

