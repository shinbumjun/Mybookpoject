<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

	<div class="container py-4">
		<!-- header class="pb-3 mb-4 border-bottom">
	      <a href="./index.do" class="d-flex align-items-center text-dark text-decoration-none">
	      <svg  width="32" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
	           <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
	           <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
	      </svg>   
	        <span class="fs-4">Home</span>
	        
	      </a>    
	    </header -->  
	    <%@ include file="menu.jsp" %>
	    
	    <%!
	    	String greeting = "Welcome to Book Shopping Mall";
   			String tagline = "저희 매장에 오신것을 환영합니다!!";
   		%>

		    <div class="row align-items-md-stretch   text-center">
		      <div class="col-md-12">
		        <div class="h-100 p-5">
		        
		          			<div class="row align-items-md-stretch   text-center">
						      <div class="col-md-12">
						        <div class="h-100 p-5">
						          <h3><%=tagline%></h3>          
						          <%
						          		// 현재 접속 시각: 4:23:55 PM
							            Date day = new java.util.Date();
							            String am_pm;
							            int hour = day.getHours();
							            int minute = day.getMinutes();
							            int second = day.getSeconds();
							            if (hour / 12 == 0) {
							               am_pm = "AM";
							            } else {
							               am_pm = "PM";
							               hour = hour - 12;
							            }
							            String CT = hour + ":" + minute + ":" + second + " " + am_pm;
							            out.println("현재 접속  시각: " + CT + "\n");
						         %>           
						        </div>
						      </div>   
				    		</div>   
				    		
				    		
		        </div>
		      </div>   
		    </div> 
   
			   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
			      <div class="container-fluid py-5">
			        <h1 class="display-5 fw-bold">도서목록</h1>
			        <p class="col-md-8 fs-4">BookList</p>      
			      </div>
			    </div>

						<div class="row align-items-md-stretch text-center">
						<c:forEach items="${listOfBooks}" var="book">
						    <div class="col-md-4">
						        <div class="h-100 p-2">         
						            <h5><b>${book.name}</b></h5>
						            
						            <img src="<c:out value='${book.imageUrl}' />" class="img-fluid rounded-start" alt="<c:out value='${book.name}' />">
						            
						            <p>${book.publisher} | ${book.unitPrice}원</p>
						                <!-- 설명 부분을 조건부로 출력, 스타일 속성을 사용하여 긴 단어가 자동으로 줄바꿈 -->
						                <c:choose>
										    <c:when test="${book.description.length() >= 60}">
										        <p style="word-wrap: break-word;">
										            ${book.description.substring(0, 60)}...<br>
										        </p>
										    </c:when>
										    <c:otherwise>
										        <p style="word-wrap: break-word;">${book.description}</p>
										    </c:otherwise>
						                </c:choose>
						            <p>${book.unitPrice}원</p>
						            <p><a href="./book.do?id=${book.bookId}" class="btn btn-secondary" role="button"> 상세 정보 &raquo;</a></p>
						        </div>   
						    </div>
						</c:forEach>

			                
			    </div>
      
		    <!-- footer class="pt-3 mt-4 text-body-secondary border-top">
		      &copy; BookMarket
		    </footer -->
		    
    		<!-- footer.jsp 파일 포함 -->
			<%@ include file="footer.jsp" %>

</body>
</html>
