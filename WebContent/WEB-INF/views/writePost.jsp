<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">

</head>
<body>

<h2>게시글 작성</h2>

<form action="createPost.do" method="post">
    <table>
        <tr>
            <td>제목:</td>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <td>작성자:</td>
            <td><input type="text" name="writer" required></td>
        </tr>
        <tr>
            <td>내용:</td>
            <td><textarea name="content" rows="10" cols="50" required></textarea></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;">
                <input type="submit" value="작성">
                <input type="reset" value="초기화">
                <button type="button" onclick="location.href='boardList.do'">취소</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
