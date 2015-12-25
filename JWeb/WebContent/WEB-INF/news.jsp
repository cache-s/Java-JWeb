<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SaberForge - News</title>
		<link href="ressources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="ressources/css/style.css">
		
	    <link rel="stylesheet" href="ressources/css/ui-lightness/jquery-ui-1.9.2.custom.css">

	    <script src="ressources/js/jquery-1.10.2.js"></script>
    	<script src="ressources/js/jquery-ui-1.9.2.custom.js"></script>
	</head>
	<body>
		<jsp:include page="header.jsp"/>

		<div class="main">
		<c:forEach var="n"  items="${requestScope.newsList}">
			<div class="news">
				<p class="newsTitle">${n.title}</p>
				<p class="newsContent">${n.content}</p>
				<p class="newsInfos">${n.date}<br/>${n.author}</p>
			</div>
		</c:forEach>
		</div>

		<jsp:include page="footer.jsp"/>
	</body>
</html>