<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<nav class="navbar navbar-default">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/admin/book">Books</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/titleSh">TitleShop</a></li>
					<li><a href="/admin/genre">Genre</a></li>
					<li><a href="/admin/author">Authors</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/lang">Languages</a></li>
					<li><a href="/admin/publisher">Publisher</a></li>
					<li><a href="/admin/seriaPub">Seria of Publish</a></li>
					<li><a href="/admin/shop">Shop</a></li>
					<li><a href="/admin/order">Orders</a></li>
				</ul>
			</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12">
		<div class="row">
				<div class="col-md-12 col-xs-12">
					<form:form class="form-inline" action="/admin/book"
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
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/book"
					method="POST" modelAttribute="book">
					<custom:hiddenInputs excludeParams="author"/>
					<div class="form-group">
						<label for="authors" class="col-sm-2 control-label">Author</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="author" id="authors"
								itemValue="id">
								<c:forEach items="${authors}" var="author">
									<form:option value="${author.id}">
										<c:out value="${author.name} ${author.surname}" />
									</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2 control-label" for="title"
							style="color: red; text-align: left;"><form:errors
								path="title" /></label>
					</div>
					<div class="form-group">
						<label for="book" class="col-sm-2 control-label">Title</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="title"
								id="book" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2 control-label"
							for="firstpub" style="color: red; text-align: left;"><form:errors
								path="firstpub" /></label>
					</div>
					<div class="form-group">
						<label for="book" class="col-sm-2 control-label">Year of
							first Pub</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="firstpub"
								id="firstpub" />
						</div>
					</div>
					<div class="form-group">
						<label for="genre" class="col-sm-2 control-label">Genre</label>
						<div class="col-sm-7">
							<form:select path="genre" items="${genres}" multiple="true"
								itemValue="id" id="genreId" itemLabel="nameOfG"
								class="form-control input-sm" />
						</div>
						<label class="col-sm-3 control-label" for="genre" style="color:red;text-align:left;"><form:errors path="genre"/></label>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-7">
							<button type="submit" class="btn btn-success btn-block">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-xs-2">
				<h3>Book title</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Year of First Pub</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Author</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Update</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="book">
			<div class="row">
				<div class="col-md-2 col-xs-2">${book.title}</div>
				<div class="col-md-2 col-xs-2">${book.firstpub}</div>
				<div class="col-md-2 col-xs-2">${book.author.name}
					${book.author.surname}</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-warning btn-xs"
						href="/admin/book/update/${book.id}">update</a>
				</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-danger btn-xs"
						href="/admin/book/delete/${book.id}">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
				<div class="col-md-6 col-xs-6">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<custom:sort innerHtml="Name asc" paramValue="title" />
							<custom:sort innerHtml="Name desc" paramValue="title,desc" />
						</ul>
					</div>
				</div>
				<div class="col-md-6 col-xs-6">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
				</div>
			</div>
	</div>
	</div>
	<div class="row">
		<div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>