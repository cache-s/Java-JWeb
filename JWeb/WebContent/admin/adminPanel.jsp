<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<title>Register</title>
<link type="text/css" rel="stylesheet" href="ressources/css/style.css" />
</head>
<body>
	<jsp:include page="../WEB-INF/header.jsp" />

	<div class="main">
		<br /> <br /> <br /> <br />
		<form action="adminPanel" method="post" class="formulaire">
			Nom | Prénom | isAdmin <br />
			<c:forEach var="user" items="${requestScope.users}">
				<c:if test="${sessionScope.userSession.email != user.email}">
    			${user.firstName} 
    			${user.lastName} :
    			<c:choose>
						<c:when test="${user.admin == '0'}">
							<button type="submit" name="set${user.email}">set Admin</button>
						</c:when>
						<c:otherwise>
							<button type="submit" name="unset${user.email}">unset Admin</button>
						</c:otherwise>
					</c:choose>
					<br />
					<br />
				</c:if>
			</c:forEach>
		</form>
	</div>
	<div class="mail">
		<form action="emailSending" method="post">
			<table border="0" width="35%" align="center">
				<caption><h2>Send Newsletter</h2></caption>
				<tr>
					<td>Subject</td>
					<td><input type="text" name="subject" size="50"/></td>
				</tr>
				<tr>
					<td>Content</td>
					<td><textarea rows="10" cols="40" name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Send"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div class="news">
		<form action="newsWriting" method="post">
			<table border="0" width="35%" align="center">
				<caption><h2>Write a News</h2></caption>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" size="50"/></td>
				</tr>
				<tr>
					<td>Content</td>
					<td><textarea rows="10" cols="40" name="newsContent"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Send"/></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../WEB-INF/footer.jsp" />
</body>
</html>