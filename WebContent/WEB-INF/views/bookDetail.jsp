<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
    <h1 class="display-5 fw-bold">도서 상세 정보</h1>
    <div class="card mb-3">
        <div class="row g-0">
            <div class="col-md-4">
            	<!-- 이미지 URL 참조를 주석 처리 -->
			    <img src="<c:out value='${book.imageUrl}' />" class="img-fluid rounded-start" alt="<c:out value='${book.name}' />">
			</div>
            
            <div class="col-md-8">
                <div class="card-body">
                    <h5 class="card-title"><c:out value='${book.name}' /></h5>
                    <p class="card-text">저자: <c:out value='${book.author}' /></p>
                    <p class="card-text">출판사: <c:out value='${book.publisher}' /></p>
                    <p class="card-text">가격: <c:out value='${book.unitPrice}' />원</p>
                    <p class="card-text">출판일: <c:out value='${book.releaseDate}' /></p>
                    <p class="card-text">설명: <c:out value='${book.description}' /></p>
                    <a href="./books.do" class="btn btn-primary">도서 목록</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
