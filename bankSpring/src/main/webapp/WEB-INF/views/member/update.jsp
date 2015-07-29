<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
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

		<div class="content">
			<div>
				<br />
				<form action="${root}/member/update.do" name="frmUpdateMember" method="post">
					<table class="tab" style="margin: 0 auto;">
						<tr>
							<td rowspan="4" style="width: 30%;"><img alt=""
								src="${context}/image/default.gif"></td>
							<td>ID</td>
							<td>${member.userid}</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="text" name="password" value="${member.password}" required="required"/></td>
						</tr>
						<tr>
							<td>이름</td>
							<td>${member.name}</td>
						</tr>
						<tr>
							<td>나이</td>
							<td>${member.age}</td>
						</tr>
						<tr>
							<td style="text-align: center;">
								<button id="updateImage" style="width: 100px">이미지변경</button>
							</td>
							<td>이메일</td>
							<td><input type="text" name="email" value="${member.email}"/></td>
						</tr>
						<tr>
							<td colspan="3"><button type="submit" style="150px;">수정완료</button></td>
						</tr>
					</table>
				</form>
				<br />
				<br />
				<br />
			</div>
			</div><!-- content end -->
			

			<div id="footer">
				<jsp:include page="../home/footer.jsp" />
			</div>
		</div><!-- wrap end -->
		<script src="${context}/js/member.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#updateImage').click(function() {
				member.updateImage();
			})
		})
	</script>
</body>
</html>

