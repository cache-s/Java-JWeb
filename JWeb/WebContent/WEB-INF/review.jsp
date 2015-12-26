<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="productCase">
	<c:forEach var="r" items="${requestScope.reviewList}">
		<div class="review">
			<p class="reviewContent">${r.content}</p>
			<p class="reviewInfos">${r.author}</p>
		</div>
	</c:forEach>
	<div class="reviewContainer">
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>	
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
		<div class="review">
			<p class="reviewContent">Wow review de type incroyable</p>
			<p class="reviewInfos">Auteur</p>
		</div>
	</div>
	<c:choose>
		<c:when test="${empty sessionScope.userSession}">
			<p>
				Afin de laisser une review vous devez vous <a href="connect">connecter</a>
				d'abord.
			</p>
		</c:when>
		<c:otherwise>
			<form class="writeReview" action="reviewWriting" method="post">
				<textarea rows="5" cols="40" name="reviewContent"></textarea>
				<br /> <input type="submit" value="Send review" />
			</form>
		</c:otherwise>
	</c:choose>
</div>