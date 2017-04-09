<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<script src="/resources/js/chosen.jquery.min.js"></script>
<style type="text/css">
body {
	padding-bottom: 70px;
	padding-top: 50px;
	background: #c2e59c; /* fallback for old browsers */
	background: -webkit-linear-gradient(to left, #c2e59c, #64b3f4);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to left, #c2e59c, #64b3f4);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

a {
	color: #f8f8f8;
	font-family: 'Raleway', sans-serif;
	font-size: 18px;
	font-weight: 500;
	line-height: 32px;
}

h3,h2,h1,p {
	color: #111;
	font-family: 'Open Sans Condensed', sans-serif;
}

.searchBox {
	background-color: #2874f0;
}

.searchGroup {
	margin-top: 15px;
}

.shopBox {
	margin-top: 15px;
}

.userButton {
	margin-top: 15px;
}
</style>
<!-- сюди буде підставлено атрибут з ім'ям title -->
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<!-- 	а сюди jsp файл з ім'ям header -->
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
		<div class="row searchBox">
			<div class="col-md-3">
				<h2 style="color: white">BookShop</h2>
			</div>
			<div class="col-md-5 searchGroup">
				<form:form class="form-inline" action="/search" method="GET"
					modelAttribute="filter">
					<custom:hiddenInputs excludeParams="search" />
					<div class="input-group col-md-9">
						<form:input path="search" class="form-control"
							placeholder="Search" />
					</div>
					<button type="submit" class="btn btn-danger">Search</button>
				</form:form>
			</div>
			<div class="col-md-2 shopBox">
			<sec:authorize access="isAuthenticated()">
				<a href="/shoppingcart"><button type="button"
								class="btn btn-success">Shopping Cart ${fn:length(order.shops)}</button></a>
			</sec:authorize>
			</div>
			<div class="col-md-1 userButton">
				<sec:authorize access="!isAuthenticated()">
					<form:form action="/login" method="GET">
						<button type="submit" class="btn btn-danger">Login</button>
					</form:form>
				</sec:authorize>
			</div>
			<div class="col-md-1 userButton">
				<sec:authorize access="!isAuthenticated()">
					<form:form action="/registration" method="GET">
						<button type="submit" class="btn btn-danger">Sign up</button>
					</form:form>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<form:form action="/logout" method="POST">
						<button type="submit" class="btn btn-danger">Logout</button>
					</form:form>
				</sec:authorize>
			</div>
		</div>
		<!-- 	сюди jsp файл з ім'ям body -->
		<tiles:insertAttribute name="body" />
	</div>
	<!-- 	сюди jsp файл з ім'ям footer -->
	<!-- 	зверніть увагу на те що в темплейт файлі (тут) -->
	<!-- 	вже описано основний HTML код, в інших файлах -->
	<!-- 	його писати не потрібно(я про <head><body><html>) -->
</body>
</html>