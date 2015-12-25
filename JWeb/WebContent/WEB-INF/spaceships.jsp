<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SaberForge - SpaceShips Shop</title>
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
	
		<div class="main">

			<div class="productBuy">
				<a class="imageBuy" href="" style="background-image:url(${requestScope.product.image_url});"></a>
				<div class="formContainer">
					<form action="https://www.paypal.com/" method="get">
						<span class="productName">${requestScope.product.name}</span>
						<br/>
	           			<span class="productDescription">${requestScope.product.description}</span>
	           			<br/><br/>
	           			<div class="priceBox">
							<span class="productPrice">${requestScope.product.price}</span>
							<br/><br/>
							<select>
								<optgroup label="How much do you want to buy">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</optgroup>
							</select>
							<br/><br/>
							<input type="submit" value="Buy now" />
						</div>
					</form>
				</div>
			</div>

		</div>
	
		<jsp:include page="footer.jsp"/>
	</body>
</html>