<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Register</title>
        <link type="text/css" rel="stylesheet" href="ressources/css/style.css" />
    </head>
    <body>
    	<jsp:include page="../WEB-INF/header.jsp"/>
    	
    	<div class="main">
    	<br/>
    	<br/>
    	<br/>
    	<br/>
    	    <form action="adminPanel" method="post" class="formulaire">
    	    	Nom | Prénom | isAdmin <br/>
    		<c:forEach var="user" items="${requestScope.users}">
    			${user.firstName} 
    			${user.lastName}
				${user.admin} :
    			<c:choose>
    				<c:when test="${user.admin == '0'}">
    					<button type="submit" name ="set${user.email}" >set Admin</button>
    				</c:when>
    				<c:otherwise>
    					<button type="submit" name ="unset${user.email}" >unset Admin</button>
    				</c:otherwise>
    			</c:choose>
    		<br/>
    		<br />
    		</c:forEach> 
    		</form>
    	</div>
    	<jsp:include page="../WEB-INF/footer.jsp"/>
	</body>
</html>