<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SaberForge - Profile</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/ressources/css/style.css"/>" />
	</head>
	<body>
		<jsp:include page="../WEB-INF/header.jsp"/>
	
		<div class="main">
		<form action="profile" method="post" class="formuaire">
			<p>Vous êtes connecté(e) avec l'adresse ${sessionScope.userSession.email}, vous avez bien accès à l'espace restreint.</p>
			<label>First name : </label>
			<input type="text" id="firstName" name="firstName" value="<c:out value="${sessionScope.userSession.firstName}"/>" size="20" maxlength="20" /><br />
			<span class="error">${form.errors['firstName']}</span>
			<label>Last name : </label>
			<input type="text" id="lastName" name="lastName" value="<c:out value="${sessionScope.userSession.lastName}"/>" size="20" maxlength="20" /><br />
			<label>Email : ${sessionScope.userSession.email}</label><br />
			<label>Username : </label>
			<input type="text" id="userName" name="userName" value="<c:out value="${sessionScope.userSession.userName}"/>" size="20" maxlength="20" /><br />
			<label>Change password : </label>
			<input type="password" id="password" name="password" size="20" maxlength="20" /><br />
			<label>Confirm password : </label>
			<input type="password" id="password2" name="password2" size="20" maxlength="20" /><br />
			<label>Address : </label>
			<input type="text" id="address" name="address" value="<c:out value="${sessionScope.userSession.address}"/>" size="20" maxlength="40" /><br />
			<label>State : </label>
			<input type="text" id="state" name="state" value="<c:out value="${sessionScope.userSession.state}"/>" size="20" maxlength="40" /><br />
			<label>City : </label>
			<input type="text" id="city" name="city" value="<c:out value="${sessionScope.userSession.city}"/>" size="20" maxlength="40" /><br />
			<label>Gender : </label>
			<input type="text" id="gender" name="gender" value="<c:out value="${sessionScope.userSession.gender}"/>" size="20" maxlength="20" /><br />
			<label>Newsletter : </label><br />
			<label for="newsletter">Suscribe to newsletter </label>
			<c:choose>
				<c:when test="${sessionScope.userSession.newsletter == '0'}">
					<input type="radio" name="newsletter" value="1">Yes
					<input type="radio" name="newsletter" value="0" checked>No<br>
				</c:when>
				<c:otherwise>
					<input type="radio" name="newsletter" value="1" checked>Yes
					<input type="radio" name="newsletter" value="0">No<br>
				</c:otherwise>
			</c:choose>
			<input class="button" type="submit" value="Submit" />
			<%--<span class="error">${form.errors['database']}</span> --%>
			<p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
			</form>
		</div>
	<jsp:include page="../WEB-INF/footer.jsp"/>
	</body>
</html>