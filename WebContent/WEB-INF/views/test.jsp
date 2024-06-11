<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
    <h1>책 목록</h1>
    <table border="1">
        <thead>
            <tr>
                <th>책 제목</th>
                <th>저자</th>
                <th>가격</th>
                <th>설명</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listOfBooks}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.unitPrice}원</td>
                    <td>${book.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
