<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
<c:set var="context" value="${root}/resources"></c:set>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<style>
@import url(${context}/css/common.css);
</style>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<div id="wrap" class="clear">
		<div id="header">
			<jsp:include page="header.jsp" />
		</div>
		<div style="float: left; width: 30%;">
			<jsp:include page="aside.jsp" />
		</div>
		<div style="float: right; width: 70%;">
			<form action="${root}/admin/member.do?command=list&pageNo=1"name="frmAdmin" id="frmAdmin">
				<table class="tab">
					<tr>
						<th style="width: 20%">ID</td>
						<th style="width: 30%">이름</td>
						<th style="width: 10%">나이</td>
						<th style="width: 40%">이메일</td>
					</tr>
					<tr>
						<td>${member.userid}</td>
						<td>${member.name}</td>
						<td>${member.age}</td>
						<td>${member.email}</td>
					</tr>
				</table>
			</form>
			<div class="pad"></div>
			<form action="${root}/admin/member.do" method="post">
				<select name="searchKey" id="searchKey">
					<option value="list" selected="selected">전체보기</option>
					<option value="userid">아이디</option>
					<option value="name">이름</option>
				</select> 
				<input type="text" name="searchVal" /> 
				<input type="hidden" name="pageNo" /> 
				<input type="hidden" name="command" value="search" />
				<input type="submit" value="검색" />
			</form>
		</div>
	</div>
</body>
</html>