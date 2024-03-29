<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../resources/css/member.css">
<meta charset="UTF-8">
<title>board</title>
</head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(document).ready(function() {
	$('#regist_btn').on("click", function() {
		location.href="./regist.do";
	})
})
</script>
<body>
<form action="./search.do" method="get">
	<div id="search">
		<select name="selectBox">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
			<option value="bno">번호</option>
		</select> 
		<input type="text" id="searchBox" name="searchBox">
		<button type="submit" id="searchBtn">검색</button>
	</div>
</form>

	<table id="join">
	<tr>
		<td colspan="4">방명록 리스트</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>조회수</td>
	</tr>
	<c:forEach items="${list }" var="guest">
		<tr>
			<td>${guest.bno}</td>
			<td>${guest.title }</td>
			<td>${guest.writer }</td>
			<td>${guest.regNo }</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="4"><button type="button" id="regist_btn">등록하기</button></td>
	</tr>
</table>
</body>
</html>