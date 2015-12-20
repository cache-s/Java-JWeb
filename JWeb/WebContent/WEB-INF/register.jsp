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
    	<jsp:include page="header.jsp"/>
    	
    	<div class="main">
    	
    	<form action="register" method="post" class="formulaire">
		    <h1>SaberForge - Register 
		        <span>Fields with a '*' are mandatory.</span>
		    </h1>

		    <label>
		        <span>First name :</span>
		        <input type="text" id="firstName" name="firstName" value="<c:out value="${user.firstName}"/>" placeholder="Your First Name" size="40" maxlength="20" />
				<span class="error">${form.errors['firstName']}</span>
		    </label>
		    
		    <label>
		        <span>Last name :</span>
                <input type="text" id="lastName" name="lastName" value="<c:out value="${user.lastName}"/>" placeholder="Your Last Name" size="40" maxlength="20" />
                <span class="error">${form.errors['lastName']}</span>
		    </label>
		    
		    <label>
		        <span>Email* :</span>
		        <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" placeholder="Your E-mail" size="40" maxlength="60" />
                <span class="error">${form.errors['email']}</span>
		    </label>
		    
		    <label>
		        <span>Username* :</span>
                <input type="text" id="userName" name="userName" value="<c:out value="${user.userName}"/>" placeholder="Your username" size="40" maxlength="20" />
                <span class="error">${form.errors['userName']}</span>
		    </label>
		    
		    <label>
		        <span>Password* :</span>
                <input type="password" id="password" name="password" value="" size="40" maxlength="20" />
                <span class="error">${form.errors['password']}</span>
		    </label>
		    
			<label>
		        <span>Confirm password* :</span>
                <input type="password" id="password2" name="password2" value="" size="40" maxlength="20" />
                <span class="error">${form.errors['password2']}</span>
		    </label>
		    
			<label>
		        <span>Address :</span>
                <input type="text" id="address" name="address" value="<c:out value="${user.address}"/>" placeholder="Your address" size="40" maxlength="20" />
                <span class="error">${form.errors['address']}</span>
		    </label>
		    
			<label>
		        <span>State :</span>
                <input type="text" id="state" name="state" value="<c:out value="${user.state}"/>" placeholder="Your State" size="40" maxlength="20" />
                <span class="error">${form.errors['state']}</span>
		    </label>
		    
			<label>
		        <span>City :</span>
                <input type="text" id="city" name="city" value="<c:out value="${user.city}"/>" placeholder="Your City" size="40" maxlength="20" />
                <span class="error">${form.errors['city']}</span>
		    </label>
		    
		     <label>
		        <span>Gender :</span>
		        <input type="text" id="gender" name="gender" value="<c:out value="${user.gender}"/>" size="40" maxlength="20" list="gender" >
				<datalist id="gender">
					<option value="Male">
					<option value="Female">
					<option value="Other">
				</datalist>
		    </label>
		    
				<label>
					<span>Suscribe to the newsletter : </span>
					<input type="radio" name="newsletter" value="1" checked>Yes
					<input type="radio" name="newsletter" value="0">No
				</label>
				
		        <input class="button" type="submit" value="register" />
                <span class="error">${form.errors['database']}</span>
				<p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
		</form>
        </div>
		<jsp:include page="footer.jsp"/>
    </body>
</html>