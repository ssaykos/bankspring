<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<c:set var="context" value="${root}/resources"></c:set>
<style>@import url(${context}/css/common.css);</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>	
<%-- ${context}/member/joinForm.do --%>

<header id="top">
	<div id="login">
		${member.name} 님 환영합니다!! |
		<a href="${root}/member/detail.do">마이페이지</a> |
		<a href="${root}/member/logout.do">로그아웃</a>
	</div>
	<div class="clear"></div>
	<nav id="topMenu">
		<table id="noneT" align="center" style="width: 80%; height: 40px;">
			<tr>
				<td class="centT"><a href="${context}/home/main.do">HOME</a></td>
				<td class="centT"><a href="${context}/bang/main.do">방명록</a></td>
				<td class="centT"><a href="${context}/dap/main.do">답글게시판</a></td>
				<td class="centT"><a href="${context}/jaro/main.do">자료실</a></td>
			</tr>
		</table>
		
	</nav>
</header>
<div id="joinForm" class="white-popup-block mfp-hide" 
	style='width:300px; height : 500px; background-color: white; margin : 0 auto;'>
	<!-- <h1>모달 테스트</h1>
	 -->
	<jsp:include page="../member/joinForm.jsp"></jsp:include>

</div>
<div id="loginForm" class="white-popup-block mfp-hide" 
style='width:300px; height : 500px; background-color: white; margin : 0 auto;'>
	<!-- <h1>모달 테스트</h1>
	 -->
	<jsp:include page="../member/loginForm.jsp"></jsp:include>

</div>
<div class="clear"></div>
<script src="${context}/js/member.js"></script>
<script src="${context}/js/magnific-popup.js"></script>
<script type="text/javascript">
	$(function() {
		$('.popupOpen').magnificPopup({
			type : 'inline',
			preloader : false,
			focus : '#username',
			modal : true,
			closeContentPos : true,
			fixedContentPos: true,
	        alignTop: false, /* 최상단위치 */
			showCloseBtn: true
		});
		$(document).on('click','.popupClose',function(e){
			e.preventDefault();
			$.magnificPopup.close();
		});
		$('#admin').click(function() {
			member.checkAdmin('${root}/admin/member.do?command=list&pageNo=1');
		});
	});
</script>
