<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
.navbar{
	background-color: #483D8B;
}
</style>
<nav class="navbar navbar-fixed-top">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li><a href="/delivery" class="text">Delivery</a></li>
			<li><a href="/payment">Payment</a></li>
			<li><a href="/contact">Contact</a></li>
			<li><a href="/about">About us</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<sec:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
					<li><a href="/admin">Admin Panel</a></li>
			</sec:authorize>
		</ul>
	</div>
</nav>
