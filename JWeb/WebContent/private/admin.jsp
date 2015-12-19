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
			<p>Vous êtes connecté(e) avec l'adresse ${sessionScope.userSession.email}, vous avez bien accès à l'espace Admin.</p>
		</div>
	<jsp:include page="../WEB-INF/footer.jsp"/>
	</body>
</html>