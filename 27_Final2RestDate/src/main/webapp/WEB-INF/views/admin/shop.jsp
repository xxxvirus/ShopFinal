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
	.foc {
	width: 30px; 
	cursor:pointer; 
	display:inline;
	}
	.foc:focus {
	width: auto; 
	z-index: 100;
</style>
<div class="row">
	<nav class="navbar navbar-default">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
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
					<li class="active"><a href="/admin/shop<custom:allParams/>">Shop</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/order">Orders</a></li>
				</ul>
			</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form class="form-horizontal filter" action="/admin/shop" method="GET" modelAttribute="filter" >
			<custom:hiddenInputs excludeParams="search, _languageIds, _categoryIds, _publisherIds, languageIds, categoryIds, publisherIds, max, min"/>
			<div class="form-group">
				<div class="col-sm-9">
					<form:input path="search" class="form-control" placeholder="Search" />
				</div>
				<div class="col-sm-2">
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="min" class="form-control" placeholder="Min"/>
				</div>
				<div class="col-sm-6">
					<form:input path="max" class="form-control" placeholder="Max"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Languages</label>
				<div class="col-sm-12">
					<form:checkboxes items="${langM}" path="languageIds" itemLabel="lang" itemValue="id"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Categories</label>
				<div class="col-sm-12">
					<form:checkboxes items="${categories}" path="categoryIds" itemLabel="nameOfC" itemValue="id"/>
				</div>
			</div>
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
				<form:form class="form-horizontal" action="/admin/shop"
					method="POST" modelAttribute="shop" enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="titleSh, shcat, shlang, shSeria, shpage, isbn, shyear, edition, shprice, file"/>
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2 control-label"
							for="titleSh" style="color: red; text-align: left;"><form:errors
								path="titleSh" /></label>
					</div>
					<div class="form-group">
						<label for="titleSh" class="col-sm-2 control-label">Title
							of book</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="titleSh" id="titleSh"
								items="${titleShops}" itemValue="id" itemLabel="namePub" />
						</div>
					</div>
					<div class="form-group">
						<label for="category" class="col-sm-2 control-label">Category</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="shcat" id="shcat"
								items="${categories}" itemValue="id" itemLabel="nameOfC" />
						</div>
					</div>
					<div class="form-group">
						<label for="languages" class="col-sm-2 control-label">Language</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="shlang" id="shlang"
								items="${langM}" itemValue="id" itemLabel="lang" />
						</div>
					</div>
					<div class="form-group">
						<label for="seriaPub" class="col-sm-2 control-label">Seria
							of publish</label>
						<div class="col-sm-7">
							<form:select class="form-control" path="shSeria" id="shSeria"
								itemValue="id">
								<c:forEach items="${series}" var="shSeria">
									<form:option value="${shSeria.id}">
										<c:out value="${shSeria.publisher.name} -- ${shSeria.nameOfS}" />
									</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group">
    					<label for="biography" class="col-sm-2 control-label">Anotation</label>
    					<div class="col-sm-7">
      						<form:textarea path="anotation" rows="6" cols="58" />
    					</div>
    					<label class="col-sm-3 control-label" for="anotation" style="color:red;text-align:left;"><form:errors path="anotation"/></label>
  					</div>
					<div class="form-group">
						<label for="shop" class="col-sm-2 control-label">Page</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="shpage"
								id="shpage" />
						</div>
						<label class="col-sm-3 control-label" for="shpage"
							style="color: red; text-align: left;"><form:errors
								path="shpage" /></label>
					</div>
					<div class="form-group">
						<label for="shop" class="col-sm-2 control-label">ISBN</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="isbn"
								id="isbn" />
						</div>
						<label class="col-sm-3 control-label" for="isbn"
							style="color: red; text-align: left;"><form:errors
								path="isbn" /></label>
					</div>
					<div class="form-group">
						<label for="shop" class="col-sm-2 control-label">Year of
							publish</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="shyear"
								id="shyear" />
						</div>
						<label class="col-sm-3 control-label" for="shyear"
							style="color: red; text-align: left;"><form:errors
								path="shyear" /></label>
					</div>
					<div class="form-group">
						<label for="shop" class="col-sm-2 control-label">Edition</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="edition"
								id="edition" />
						</div>
						<label class="col-sm-3 control-label" for="edition"
							style="color: red; text-align: left;"><form:errors
								path="edition" /></label>
					</div>
					<div class="form-group">
						<label for="shop" class="col-sm-2 control-label">Price</label>
						<div class="col-sm-7">
							<form:input type="text" class="form-control" path="shprice"
								id="shprice" />
						</div>
						<label class="col-sm-3 control-label" for="shprice"
							style="color: red; text-align: left;"><form:errors
								path="shprice" /></label>
					</div>
					<div class="form-group">
    					<label for="file" class="col-sm-2 control-label">Image</label>
    					<div class="col-sm-7">
      						<input type="file" name="file" id="file">
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
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
				<div class="col-md-6 col-xs-6">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
				</div>
			</div>
	</div>
	<div class="col-md-12 col-xs-12">
		<div class="row">
			<div class="col-md-1 col-xs-1">
				<h3>Image</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Title</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Original Ttile</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Author</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Publisher</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Seria</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Language</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>First pub</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Year of pub</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Price</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Update</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="shop">
			<div class="row">
				<div class="col-md-1 col-xs-1"><img border="0" src="/images/shop/${shop.id}.jpg?version=${shop.version}" class="foc" tabindex="1"/></div>
				<div class="col-md-1 col-xs-1">${shop.titleSh.namePub}</div>
				<div class="col-md-1 col-xs-1">${shop.titleSh.book.title}</div>
				<div class="col-md-1 col-xs-1">${shop.titleSh.book.author.name} ${shop.titleSh.book.author.surname}</div>
				<div class="col-md-1 col-xs-1">${shop.shSeria.publisher.name}</div>
				<div class="col-md-1 col-xs-1">${shop.shSeria.nameOfS}</div>
				<div class="col-md-1 col-xs-1">${shop.shlang.lang}</div>
				<div class="col-md-1 col-xs-1">${shop.titleSh.book.firstpub}</div>
				<div class="col-md-1 col-xs-1">${shop.shyear}</div>
				<div class="col-md-1 col-xs-1">${shop.shprice}</div>
				<div class="col-md-1 col-xs-1">
					<a class="btn btn-warning btn-xs"
						href="/admin/shop/update/${shop.id}<custom:allParams/>">update</a>
				</div>
				<div class="col-md-1 col-xs-1">
					<a class="btn btn-danger btn-xs"
						href="/admin/shop/delete/${shop.id}<custom:allParams/>">delete</a>
				</div>
			</div>
			<div class="col-md-12 col-xs-12"></div>
		</c:forEach>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>