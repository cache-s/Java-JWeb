<!DOCTYPE html>
<html>
	<head>
<meta charset="utf-8" />
		<title>SaberForge - Contact</title>
		<link href="ressources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
		
	    <link rel="stylesheet" href="ressources/css/ui-lightness/jquery-ui-1.9.2.custom.css">

	    <script src="ressources/js/jquery-1.10.2.js"></script>
    	<script src="ressources/js/jquery-ui-1.9.2.custom.js"></script>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
	
		<div class="main">
			<form action="register" method="post" class="formulaire">
		    <h1>SaberForge - Contact us
		        <span>We reply to all E-mails we get</span>
		    </h1>

		    <label>
		        <span class="labelName">Name :</span>
		        <input type="text" id="firstName" name="firstName" placeholder="Your Name" size="40" />
				<span class="error">${form.errors['name']}</span>
		    </label>
		    
		    <label>
		        <span class="labelName">Email :</span>
		        <input type="email" id="email" name="email" placeholder="Your E-mail" size="40" maxlength="60" />
                <span class="error">${form.errors['email']}</span>
		    </label>
		    
		    <label>
		        <span class="labelName">Object :</span>
                <input type="text" id="emailObject" name="emailObject" placeholder="Object" size="40" maxlength="20" />
                <span class="error">${form.errors['emailObject']}</span>
		    </label>
		    
		    <label>
		    	<span class="labelName">Message :</span><br/>
				<textarea rows="10" cols="40" name="reviewContent"></textarea>
                <span class="error">${form.errors['emailMessage']}</span>
		    </label>
				
		        <input class="button" type="submit" value="Send" />
                <span class="error">${form.errors['database']}</span>
				<p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
		</form>
		</div>
	
		<jsp:include page="footer.jsp"/>
	</body>
</html>