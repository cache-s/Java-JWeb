<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="review">
	<c:forEach var="r" items="${requestScope.reviewList}">
		<div class="review">
			<p class="reviewContent">${r.content}</p>
			<p class="reviewInfos">${r.author}</p>
		</div>
	</c:forEach>
	<c:choose>
		<c:when test="${empty sessionScope.userSession}">
			<p>
				Afin de laisser une review vous devez vous <a href="connect">connecter</a>
				d'abord.
			</p>
		</c:when>
		<c:otherwise>
			<form action="reviewWriting" method="post">
				<textarea rows="10" cols="40" name="reviewContent"></textarea>
				<br /> <input type="submit" value="Send" />
			</form>
		</c:otherwise>
	</c:choose>
</div>