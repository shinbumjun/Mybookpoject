<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>API 테스트</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-compat/3.0.0-alpha1/jquery.min.js"></script>

</head>
<body>
	<h1>우리나라 대기정보</h1>
	<div>
		<button onclick="updataTable();">대기오염 갱신</button>
	</div>
	<div class="error0"></div>
	<table class="table">
		<thead>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>