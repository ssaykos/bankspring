<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
<c:set var="context" value="${root}/resources"></c:set>
<style>@import url(${context}/css/common.css);</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>	

<aside class="aside">
	<table>
		<tr>
			<td><a href="${root}/"><b style="font-size: 32px">회원관리</b></a></td>
		</tr>
		<tr>
			<td><a href="${root}/"><b style="font-size: 32px">도서관리</b></a></td>
		</tr>
		<tr>
			<td><a href="${root}/"><b style="font-size: 32px">통계보기</b></a></td>
		</tr>
		<tr>
			<td><a href="${root}/"><b style="font-size: 32px">회사정보</b></a></td>
		</tr>
	</table>
</aside>