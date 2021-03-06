<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SaberForge - Index</title>
		<link href="ressources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
		
	    <link rel="stylesheet" href="ressources/css/ui-lightness/jquery-ui-1.9.2.custom.css">

	    <script src="ressources/js/jquery-1.10.2.js"></script>
    	<script src="ressources/js/jquery-ui-1.9.2.custom.js"></script>
	</head>

	<body>
		<jsp:include page="header.jsp"/>

		<div class="mainIndex">
		
			<div class="position1 col-lg-12">
                <div id="myCarousel" class="carousel slide">
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
                        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                        <li data-target="#myCarousel" data-slide-to="2" class="active"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item">
                            <div class="fill slide1"></div>
                        </div>
                        <div class="item">
                            <div class="fill slide2"></div>
                        </div>
                        <div class="item active">
                            <div class="fill slide3"></div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="indexLayout">
            	<div class="product">
            		<a class="lightsaber1" href="lightsabers"></a>
            		<p>
						<span class="lightsaber1Name">${requestScope.lightsaber.name}</span>
            			<span class="lightsaber1Description">${requestScope.lightsaber.description}</span>
            			<span class="lightsaber1Price">${requestScope.lightsaber.price} SFC</span>
            		</p>
            	</div>

            	<div class="product">
					<a class="blaster1" href="blasters"></a>
            		<p>
						<span class="blaster1Name">${requestScope.blaster.name}</span>
            			<span class="blaster1Description">${requestScope.blaster.description}</span>
            			<span class="blaster1Price">${requestScope.blaster.price} SFC</span>
            		</p>
				</div>

            	<div class="product">
					<a class="spaceship1" href="spaceships"></a>
            		<p>
						<span class="spaceship1Name">${requestScope.spaceship.name}</span>
            			<span class="spaceship1Description">${requestScope.spaceship.description}</span>
            			<span class="spaceship1Price">${requestScope.spaceship.price} SFC</span>
            		</p>
            	</div>
            </div>
		</div>

		<jsp:include page="footer.jsp"/>
	</body>

	<script src="ressources/js/bootstrap.min.js"></script>
	<script>
		$('.carousel').carousel({
		interval: 5000
		})
	</script>
</html>