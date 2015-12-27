<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8" />
        <title>SaberForge - Profile</title>
		<link href="ressources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
		
	    <link rel="stylesheet" href="ressources/css/ui-lightness/jquery-ui-1.9.2.custom.css">

	    <script src="ressources/js/jquery-1.10.2.js"></script>
    	<script src="ressources/js/jquery-ui-1.9.2.custom.js"></script>
	</head>
	<body>
		<jsp:include page="../WEB-INF/header.jsp"/>
	
		<div class="main">
		
		<form action="profile" method="post" class="formulaire">
		    <h1>SaberForge - Profile 
		        <span>You are connected with the adress ${sessionScope.userSession.email}</span>
		    </h1>

		    <label>
		        <span class="labelName">First name :</span>
		        <input type="text" id="firstName" name="firstName" value="<c:out value="${sessionScope.userSession.firstName}"/>" size="40" />
		    </label>
		    
		    <label>
		        <span class="labelName">Last name :</span>
                <input type="text" id="lastName" name="lastName" value="<c:out value="${sessionScope.userSession.lastName}"/>" size="40" />
		    </label>
		    
		    <label>
		        <span class="labelName">Email : </span>
		        <input type="email" id="email" name="email" value="<c:out value="${sessionScope.userSession.email}"/>" size="40" maxlength="60" readonly/>
		    </label>
		    
		    <label>
		        <span class="labelName">Username :</span>
                <input type="text" id="userName" name="userName" value="<c:out value="${sessionScope.userSession.userName}"/>" placeholder="Your username" size="40" maxlength="20" />
		    </label>
		    
		    <label>
		        <span class="labelName">Change password :</span>
                <input type="password" id="password" name="password" value="" size="40" maxlength="20" />
		    </label>
		    
			<label>
		        <span class="labelName">Confirm password :</span>
                <input type="password" id="password2" name="password2" value="" size="40" maxlength="20" />
		    </label>		    
		    
			<label>
		        <span class="labelName">Address :</span>
                <input type="text" id="address" name="address" value="<c:out value="${sessionScope.userSession.address}"/>" placeholder="Your address" size="40"/>
		    </label>
		    
			<label>
		        <span class="labelName">State :</span>
                <input type="text" id="state" name="state" value="<c:out value="${sessionScope.userSession.state}"/>" placeholder="Your State" size="40" />
		    </label>
		    
			<label>
		        <span class="labelName">City :</span>
                <input type="text" id="city" name="city" value="<c:out value="${sessionScope.userSession.city}"/>" placeholder="Your City" size="40" />
		    </label>
		    
		     <label>
		        <span class="labelName">Gender :</span>
		        <input type="text" id="gender" name="gender" value="<c:out value="${sessionScope.userSession.gender}"/>" placeholder="Your Gender" size="40" list="gender" >
				<datalist id="gender">
					<option value="Male">
					<option value="Female">
					<option value="Other">
				</datalist>
		    </label>
		    
			<label>
				<span class="labelName">Suscribe to the newsletter : </span>
				<c:choose>
					<c:when test="${sessionScope.userSession.newsletter == '0'}">
						<input type="radio" name="newsletter" value="1">Yes
						<input type="radio" name="newsletter" value="0" checked>No
					</c:when>
					<c:otherwise>
						<input type="radio" name="newsletter" value="1" checked>Yes
						<input type="radio" name="newsletter" value="0">No
					</c:otherwise>
			</c:choose>
			</label>
			
	        <input class="button" type="submit" value="Submit" />
			<p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
		</form>

		</div>
	<jsp:include page="../WEB-INF/footer.jsp"/>
	</body>
</html>