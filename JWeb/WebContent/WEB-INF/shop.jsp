<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SaberForge - Shop</title>
		<link href="ressources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
		
	    <link rel="stylesheet" href="ressources/css/ui-lightness/jquery-ui-1.9.2.custom.css">

	    <script src="ressources/js/jquery-1.10.2.js"></script>
    	<script src="ressources/js/jquery-ui-1.9.2.custom.js"></script>
	</head>
	<body>
		<jsp:include page="header.jsp"/>

		<div class="main">
			<div class="shopLayout">
	           	<div class="category">
	           		<a href="lightsabers" class="lightsabers"></a>
	            </div>
	            <div class="category">
	           		<a href="blasters" class="blasters"></a>
	            </div>
	            <div class="category">
	           		<a href="spaceships" class="spaceships"></a>
	            </div>
			</div>
		</div>

		<jsp:include page="footer.jsp"/>
	</body>
</html>