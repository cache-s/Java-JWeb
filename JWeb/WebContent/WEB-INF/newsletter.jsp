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
		
		<form action="newsletter" method="post" class="formulaire">
		    <h1>SaberForge - Subscribe to the Newsletter 
		    </h1>

		    <label>
		        <span>Email :</span>
		        <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" placeholder="Your E-mail" size="40" maxlength="60" />
                <span class="error">${form.errors['email']}</span>
		    </label>
		    
		    <input class="button" type="submit" value="Subscribe" />
            <span class="error">${form.errors['database']}</span>
			<p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
		</form>
		
		</div>
	
		<jsp:include page="footer.jsp"/>
	</body>
</html>