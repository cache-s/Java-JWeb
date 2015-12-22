<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
	<div class="logo">
		<a href="index" title="Home page"></a>
	</div>

	<!-- Menu Above -->
	<div class="navigationAbove">
		<span class="baseline"><em>Sith or Jedi, find the perfect
				lightsaber !</em></span>
		<nav class="user">
			<c:choose>
				<c:when test="${empty sessionScope.userSession}">
					<a href="register"
						title="Create account">Register</a>
					<span>·</span>
					<a href="connect"
						title="Connect to your account">Connect</a>
					<span>·</span>
					<a href="newsletter"
						title="Subscribe to the newsletter">Newsletter</a>
				</c:when>
				<c:otherwise>
					<a href="profile" title="Profile">Profile</a>
					<span>·</span>
					<a href="disconnect" title="Profile">Disconnect</a>
				</c:otherwise>
			</c:choose>
		</nav>
	</div>

	<!-- Menu Bellow -->
	<nav class="navigationBellow">
		<ul>
			<li><a href="index" title="Home page">Home</a>
			</li>
			<li><a href="shop"
				title="Buy lightsabers">Shop</a></li>
			<li><a href="profile"
				title="Manage your account">Profile</a></li>
			<li><a href="aboutus"
				title="Learn more about us">About us</a></li>
			<li><a href="contact"
				title="Contact us">Contact</a></li>
			<c:if test="${sessionScope.userSession.admin == '1'}">
			<li><a href="adminPanel"
				title="adminPanel">Panel admin</a></li>
			</c:if>
			<li class="cart"><a href="cart"
				title="Your cart">Cart (0)</a></li>
		</ul>
	</nav>
</header>