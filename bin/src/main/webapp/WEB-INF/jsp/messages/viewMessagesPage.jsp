<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewMessages</title>
</head>
<body>
	<div class="container">
		<p />
		<c:forEach var="workMessages" items="${page.content}">
			<div class="row justify-content-center">
				<div class="col-9">
					<div class="card">
						<div class="card-header">
							Add Message Time:
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE"
								value="${workMessages.added}" />
						</div>
						<div class="card-body">
							<div>
								<c:out value="${workMessages.text}" />
								<div>
									<a href="${contextRoot}/editMessage?id=${workMessages.id}">Edit</a>&nbsp|
									<a href="${contextRoot}/deleteMessage?id=${workMessages.id}" onClick="return confirm('確定刪除?');">Delete</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="row justify-content-center">
			<div class="col-9">
				<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
					<c:choose>
						<c:when test="${page.number != pageNumber -1}">
							<a href="${contextRoot}/viewMessages?p=${pageNumber}"><c:out
									value="${pageNumber}" /> </a>
						</c:when>
						<c:otherwise>
							<c:out value="${pageNumber}" />
						</c:otherwise>
					</c:choose>
					<c:if test="${pageNumber != page.totalPages}">
					|
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>