<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<div class="logo">
		<a href="" title="Home page"></a>
	</div>

	<!-- Menu Above -->
	<div class="navigationAbove">
		<span class="baseline"><em>Sith or Jedi, find the perfect
				lightsaber !</em></span>
		<nav class="user">
			<c:choose>
				<c:when test="${empty sessionScope.userSession}">
					<a href="http://localhost:8080/JWeb/register"
						title="Create account">Register</a>
					<span>·</span>
					<a href="http://localhost:8080/JWeb/connect"
						title="Connect to your account">Connect</a>
					<span>·</span>
					<a href="http://localhost:8080/JWeb/newsletter"
						title="Subscribe to the newsletter">Newsletter</a>
				</c:when>
				<c:otherwise>
					<a href="http://localhost:8080/JWeb/profile" title="Profile">Profile</a>
				</c:otherwise>
			</c:choose>
		</nav>
	</div>

	<!-- Menu Bellow -->
	<nav class="navigationBellow">
		<ul>
			<li><a href="http://localhost:8080/JWeb/index" title="Home page">Home</a>
			</li>
			<li><a href="http://localhost:8080/JWeb/shop"
				title="Buy lightsabers">Shop</a></li>
			<li><a href="http://localhost:8080/JWeb/profile"
				title="Manage your account">Profile</a></li>
			<li><a href="http://localhost:8080/JWeb/aboutus"
				title="Learn more about us">About us</a></li>
			<li><a href="http://localhost:8080/JWeb/contact"
				title="Contact us">Contact</a></li>
			<li class="cart"><a href="http://localhost:8080/JWeb/cart"
				title="Your cart">Cart (0)</a></li>
		</ul>
	</nav>
</header>