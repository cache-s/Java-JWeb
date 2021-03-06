<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<jsp:include page="header.jsp" />
	
		<div class="main">
			<div class="productBuy">
				<a class="productCase" href="" style="background-position:center;background-image:url(${requestScope.product.image_url});"></a>
				<div class="productCase">
					<form action="https://www.paypal.com/" method="get">
						<span class="productName">${requestScope.product.name}</span> <br />
						<span class="productDescription">${requestScope.product.description}</span>
						<br />
						<br />
						<div class="priceBox">
							<span class="productPrice">${requestScope.product.price} SFC</span> <br />
							<br /> <select>
								<optgroup label="How much do you want to buy">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</optgroup>
							</select> <br />
							<br /> <input type="submit" value="Buy now" />
						</div>
					</form>
				</div>
			<jsp:include page="review.jsp" />
			</div>
		</div>
	
		<jsp:include page="footer.jsp" />
	</body>
</html>