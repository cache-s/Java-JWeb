<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Register</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
    </head>
    <body>
        <form method="post" action="register">
            <fieldset>
                <legend>Register</legend>
                <p>Register here</p>

 				<label for="firstName">First name</label>
                <input type="text" id="firstName" name="firstName" value="<c:out value="${param.firstName}"/>" size="20" maxlength="20" />
                <span class="error">${errors['firstName']}</span>
                <br />
                
                <label for="lastName">First name</label>
                <input type="text" id="lastName" name="lastName" value="<c:out value="${param.lastName}"/>" size="20" maxlength="20" />
                <span class="error">${errors['lastName']}</span>
                <br />
                
                <label for="email">Email <span class="required">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="60" />
                <span class="error">${errors['email']}</span>
                <br />

                <label for="userName">User name <span class="required">*</span></label>
                <input type="text" id="userName" name="userName" value="<c:out value="${param.userName}"/>" size="20" maxlength="20" />
                <span class="error">${errors['userName']}</span>
                <br />

                <label for="password">Password<span class="requis">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="error">${errors['password']}</span>
                <br />

                <label for="password2">Confirm password<span class="requis">*</span></label>
                <input type="password" id="password2" name="password2" value="" size="20" maxlength="20" />
                <span class="error">${errors['password2']}</span>
                <br />
				
                <label for="address">address</label>
                <input type="text" id="address" name="address" value="<c:out value="${param.address}"/>" size="20" maxlength="20" />
                <span class="error">${errors['address']}</span>
                <br />

                <label for="state">State</label>
                <input type="text" id="state" name="state" value="<c:out value="${param.state}"/>" size="20" maxlength="20" />
                <span class="error">${errors['state']}</span>
                <br />
                
				<label for="city">City</label>
                <input type="text" id="City" name="City" value="<c:out value="${param.City}"/>" size="20" maxlength="20" />
                <span class="error">${errors['City']}</span>
                <br />
                
                <label for="gender">Gender</label>
				<input list="gender">
				<datalist id="gender">
					<option value="Male">
					<option value="Female">
					<option value="Sith">
					<option value="Jedi">
					<option value="Other">
				</datalist>
                <br />

                <input type="submit" value="register" />
                <br />
            </fieldset>
        </form>
    </body>
</html>