<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddMessage</title>
</head>
<body>
	<div class="container">
		<p />
		<div class="row justify-content-center">
			<div class="col-9">
				<div class="card">
					<h5 class="card-header">Add your Message</h5>
					<div class="card-body">
						<form:form class="form" action="${contextRoot}/addMessage"
							modelAttribute="workMessages" method="post">
							<form:errors path="text"/>
							<form:textarea path="text" class="form-control" />
							<input type="submit" name="submit" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-9">
				<div class="card">
					<div class="card-header">
						Last update time <span><fmt:formatDate
								pattern="yyyy-MM-dd HH:mm:ss EEEE"
								value="${lastestMessage.added}" /></span>
					</div>
					<div class="card-body">
						<c:out value="${lastestMessage.text}" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>