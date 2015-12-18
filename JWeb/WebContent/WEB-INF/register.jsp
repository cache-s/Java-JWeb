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
        <form method="post" action="register">
            <fieldset>
                <legend>Register</legend>
				<p>Register here</p>

				<label for="firstName">First name</label>
				<input type="text" id="firstName" name="firstName" value="<c:out value="${user.firstName}"/>" size="40" maxlength="20" />
				<span class="error">${form.errors['firstName']}</span>
				<br />
                
                <label for="lastName">Last name</label>
                <input type="text" id="lastName" name="lastName" value="<c:out value="${user.lastName}"/>" size="40" maxlength="20" />
                <span class="error">${form.errors['lastName']}</span>
                <br />
                
                <label for="email">Email <span class="required">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="40" maxlength="60" />
                <span class="error">${form.errors['email']}</span>
                <br />

                <label for="userName">User name <span class="required">*</span></label>
                <input type="text" id="userName" name="userName" value="<c:out value="${user.userName}"/>" size="40" maxlength="20" />
                <span class="error">${form.errors['userName']}</span>
                <br />

                <label for="password">Password<span class="requis">*</span></label>
                <input type="password" id="password" name="password" value="" size="40" maxlength="20" />
                <span class="error">${form.errors['password']}</span>
                <br />

                <label for="password2">Confirm password<span class="requis">*</span></label>
                <input type="password" id="password2" name="password2" value="" size="40" maxlength="20" />
                <span class="error">${form.errors['password2']}</span>
                <br />
				
                <label for="address">address</label>
                <input type="text" id="address" name="address" value="<c:out value="${user.address}"/>" size="40" maxlength="20" />
                <span class="error">${form.errors['address']}</span>
                <br />

                <label for="state">State</label>
                <input type="text" id="state" name="state" value="<c:out value="${user.state}"/>" size="40" maxlength="20" />
                <span class="error">${form.errors['state']}</span>
                <br />
                
				<label for="city">City</label>
                <input type="text" id="city" name="city" value="<c:out value="${user.city}"/>" size="40" maxlength="20" />
                <span class="error">${form.errors['city']}</span>
                <br />
                
                <label for="gender">Gender</label>
				<input type="text" id="gender" name="gender" value="<c:out value="${user.gender}"/>" size="40" maxlength="20" list="gender" >
				<datalist id="gender">
					<option value="Male">
					<option value="Female">
					<option value="Sith">
					<option value="Jedi">
					<option value="Other">
				</datalist>
                <br />

                <input type="submit" value="register" /> <br />
                <span class="error">${form.errors['database']}</span> <br />
				<p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
                
            </fieldset>
        </form>
        </div>
		<jsp:include page="footer.jsp"/>
    </body>
</html>