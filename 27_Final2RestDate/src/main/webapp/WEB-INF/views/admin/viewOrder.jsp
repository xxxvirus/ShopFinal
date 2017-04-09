<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<nav class="navbar navbar-default">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/book">Books</a></li>
					<li><a href="/admin/titleSh">TitleShop</a></li>
					<li><a href="/admin/genre">Genres</a></li>
					<li><a href="/admin/author">Authors</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/lang">Languages</a></li>
					<li><a href="/admin/publisher">Publisher</a></li>
					<li><a href="/admin/seriaPub">Seria of Publish</a></li>
					<li><a href="/admin/shop">Shop</a></li>
					<li class="active"><a href="/admin/order">Orders</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
	</nav>
</div>
<div class="col-md-12 col-xs-12">
	<div class="row text-center">
		<h3>Information:</h3>
	</div>
	<div class="row">
		<div class="col-md-2 col-xs-2"><h3>ID</h3></div>
		<div class="col-md-3 col-xs-3"><h3>Email</h3></div>
		<div class="col-md-2 col-xs-2"><h3>Name</h3></div>
		<div class="col-md-2 col-xs-2"><h3>Surname</h3></div>
		<div class="col-md-3 col-xs-3"><h3>Phone number</h3></div>
	</div>
	<div class="row">
		<div class="col-md-2 col-xs-2">${orders.id}</div>
		<div class="col-md-3 col-xs-3">${orders.user.email}</div>
		<div class="col-md-2 col-xs-2">${orders.user.name}</div>
		<div class="col-md-2 col-xs-2">${orders.user.surname}</div>
		<div class="col-md-3 col-xs-3">${orders.user.phoneNumber}</div>
	</div>
	<div class="row text-center">
		<h3>Books:</h3>
	</div>
	<div class="row">
		<div class="col-md-2 col-xs-2"><h3>Title</h3></div>
		<div class="col-md-3 col-xs-3"><h3>Author</h3></div>
		<div class="col-md-2 col-xs-2"><h3>Publisher</h3></div>
		<div class="col-md-2 col-xs-2"><h3>Language</h3></div>
		<div class="col-md-3 col-xs-3"><h3>Price</h3></div>
	</div>
	<div class="row">
		<c:forEach items="${orders.shops}" var="shops">
			<div class="row">
				<div class="col-md-2 col-xs-2">${shops.titleSh.namePub}</div>
				<div class="col-md-3 col-xs-3">${shops.titleSh.book.author.name} ${shops.titleSh.book.author.surname}</div>
				<div class="col-md-2 col-xs-2">${shops.shSeria.publisher.name}</div>
				<div class="col-md-2 col-xs-2">${shops.shlang.lang}</div>
				<div class="col-md-3 col-xs-3">${shops.shprice}</div>
			</div>
		</c:forEach>
	</div>
	<div class="row text-center">
		<c:set var="total" value="${0}"/>
			<c:forEach var="shops" items="${orders.shops}">
   			<c:set var="total" value="${total + shops.shprice}" />
		</c:forEach>
		<h3>Total Price: ${total}</h3>
	</div>
</div>