<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
<c:set var="context" value="${root}/resources"></c:set>
<style>@import url(${context}/css/common.css);</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>	
<%-- ${context}/member/joinForm.do --%>

<header id="top">
	<div id="login">
		<a href="${root}/home/main.do">로그아웃</a>
	</div>
	<div class="clear"></div>
	<nav id="topMenu">
		<table id="noneT" align="center" style="width: 80%; height: 40px;">
			<tr>
				<td class="centT">관리자페이지</td>
			</tr>
		</table>
		
	</nav>
</header>

