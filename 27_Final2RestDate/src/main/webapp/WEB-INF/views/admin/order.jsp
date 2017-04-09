<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.buttonsMenu{
	margin-top: 15px;
}
</style>
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
<div class="col-md-3 col-xs-12">
	<div class="row">
		<div class="col-md-12 col-xs-12">
			<form:form class="form-inline" action="/admin/order"
						method="GET" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search" />
				<div class="form-group">
					<form:input path="search" class="form-control"
							placeholder="Search" />
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>
	</div>
	<div class="row buttonsMenu">
		<div class="col-md-6 col-xs-6">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<custom:sort innerHtml="Id asc" paramValue="id" />
					<custom:sort innerHtml="Id desc" paramValue="id,desc" />
				</ul>
			</div>
		</div>
		<div class="col-md-6 col-xs-6">
			<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
		</div>
	</div>
</div>
<div class="col-md-9 col-xs-12">
	<div class="row">
		<div class="col-md-3 col-xs-3"><h3>Email</h3></div>
		<div class="col-md-2 col-xs-2"><h3>Name</h3></div>
		<div class="col-md-2 col-xs-2"><h3>Surname</h3></div>
		<div class="col-md-2 col-xs-2"><h3>Phone number</h3></div>
		<div class="col-md-1 col-xs-1"><h3>View</h3></div>
		<div class="col-md-1 col-xs-1"><h3>Send</h3></div>
		<div class="col-md-1 col-xs-1"><h3>Delete</h3></div>
	</div>
	<c:forEach items="${page.content}" var="order">
		<div class="row">
			<div class="col-md-3 col-xs-3">${order.user.email}</div>
			<div class="col-md-2 col-xs-2">${order.user.name}</div>
			<div class="col-md-2 col-xs-2">${order.user.surname}</div>
			<div class="col-md-2 col-xs-2">${order.user.phoneNumber}</div>
			<div class="col-md-1 col-xs-1"><a class="btn btn-success" href="/admin/order/viewOrder/${order.id}">View</a></div>
			<c:if test="${order.send==true}">
				<div class="col-md-1 col-xs-1"><a class="btn btn-success btn-xs" href="/admin/order/unsend/${order.id}">sended</a></div>
			</c:if>
			<c:if test="${order.send!=true}">
				<div class="col-md-1 col-xs-1"><a class="btn btn-danger btn-xs" href="/admin/order/send/${order.id}">send</a></div>
			</c:if>
			<div class="col-md-1 col-xs-1"><a class="btn btn-danger btn-xs" href="/admin/order/delete/${order.id}">delete</a></div>
		</div>
	</c:forEach>
</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
	</div>
</div>
