<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SaberForge - Connect</title>
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="main">
        <form method="post" action="connect">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="name">Adresse email <span class="required">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="20" maxlength="60" />
                <span class="error">${form.errors['email']}</span>
                <br />

                <label for="password">Mot de passe <span class="required">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="error">${form.errors['password']}</span>
                <br />

                <input type="submit" value="connect"/>
                <br />
                
                <p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
                
                  <c:if test="${!empty sessionScope.userSession}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.userSession.email}</p>
                </c:if>
                
            </fieldset>
        </form>	
        </div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>