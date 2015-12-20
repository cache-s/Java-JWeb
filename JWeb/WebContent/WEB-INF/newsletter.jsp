<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SaberForge - Newsletter</title>
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
	
		<div class="main">
		<form method="post" action="newsletter">
			<br />
			<br />
			<label for="name">Adresse email <span class="required">*</span></label>
			<input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="20" maxlength="60" />
			<span class="error">${form.errors['email']}</span>
			<br />
			<input type="submit" value="Suscribe"/><br />
			<span class="error">${form.errors['database']}</span>
			<p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
			
			<br />		
			</form>
		</div>
	
		<jsp:include page="footer.jsp"/>
	</body>
</html>