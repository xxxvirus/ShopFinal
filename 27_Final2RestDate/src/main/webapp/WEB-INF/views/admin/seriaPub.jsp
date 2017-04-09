<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
	.filter .control-label{
		text-align: left;
	}
	.filter span{
		display: block;
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
					<li class="active"><a href="/admin/seriaPub<custom:allParams/>">Seria of Publish</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/shop">Shop</a></li>
					<li><a href="/admin/order">Orders</a></li>
				</ul>
			</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form class="form-horizontal filter" action="/admin/seriaPub" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="_publisherIds, publisherIds"/>
			<div class="form-group">
				<label class="control-label col-sm-12">Publishers</label>
				<div class="col-sm-12">
					<form:checkboxes items="${publishers}" path="publisherIds" itemLabel="name" itemValue="id"/>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/seriaPub" method="POST" modelAttribute="seriaPub">
					<div class="form-group">
    					<label for="publisher" class="col-sm-2 control-label">Name of Publisher</label>
    					<div class="col-sm-7">
							<form:select class="form-control" path="publisher" id="publisher"
								items="${publishers}" itemValue="id" itemLabel="name" />
						</div>
  					</div>
  					<div class="form-group">
						<label class="col-sm-7 col-sm-offset-2 control-label" for="nameOfS" style="color:red;text-align:left;"><form:errors path="nameOfS"/></label>
					</div>
  					<div class="form-group">
    					<label for="seriaPub" class="col-sm-2 control-label">SeriaPub</label>
    					<div class="col-sm-7">
    						<form:input type="text" class="form-control" path="nameOfS" id="nameOfS"/>
    					</div>
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
			<div class="col-md-3 col-xs-3"><h3>Name of Seria</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Name of Publisher</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Update</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${page.content}" var="seriaPub">
				<div class="row">
					<div class="col-md-3 col-xs-3">${seriaPub.nameOfS}</div>
					<div class="col-md-3 col-xs-3">${seriaPub.publisher.name}</div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-warning btn-xs" href="/admin/seriaPub/update/${seriaPub.id}<custom:allParams/>">update</a></div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-danger btn-xs" href="/admin/seriaPub/delete/${seriaPub.id}<custom:allParams/>">delete</a></div>
				</div>
				<div class="col-md-12 col-xs-12"></div>
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
							<custom:sort innerHtml="NameOfS asc" paramValue="nameOfS" />
							<custom:sort innerHtml="NameOfS desc" paramValue="nameOfS,desc" />
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