<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style type="text/css">
.filter .control-label {
	text-align: left;
}

.filter span {
	display: block;
}
.poster{
	width: 140px;
    height: 200px;
}
</style>
<div class="container-fluid">
	<div class="row">
		<h3>${genre.nameOfG}</h3>
		<p>${genre.aboutG}</p>
	</div>
	<div class="row">
		<div class="col-md-9"></div>
		<div class="col-md-3">
				<div class="col-md-6 col-xs-6">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<custom:sort innerHtml="Name asc" paramValue="titleSh" />
							<custom:sort innerHtml="Name desc" paramValue="titleSh,desc" />
						</ul>
					</div>
				</div>
				<div class="col-md-6 col-xs-6">
					<custom:size posibleSizes="12, 24, 48" size="${page.size}" />
				</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<form:form class="form-horizontal filter" action="/genre/${genre.id}"
				method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="_languageIds, _categoryIds, _publisherIds, languageIds, categoryIds, publisherIds, max, min" />
				<div class="form-group">
					<div class="col-sm-6">
						<form:input path="min" class="form-control" placeholder="Min" />
					</div>
					<div class="col-sm-6">
						<form:input path="max" class="form-control" placeholder="Max" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Languages</label>
					<div class="col-sm-12">
						<form:checkboxes items="${langM}" path="languageIds"
							itemLabel="lang" itemValue="id" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Categories</label>
					<div class="col-sm-12">
						<form:checkboxes items="${categories}" path="categoryIds"
							itemLabel="nameOfC" itemValue="id" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-12">Publishers</label>
					<div class="col-sm-12">
						<form:checkboxes items="${publishers}" path="publisherIds"
							itemLabel="name" itemValue="id" />
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>

		<div class="col-md-9">
			<c:forEach items="${page.content}" var="shop">
				<c:if test="${shop.titleSh.book.genre.id==genre.id}">
					<div class="col-md-3">
						<div class="row">
							<div><a href="/shop/${shop.id}"><img src="/images/shop/${shop.id}.jpg" class="poster"></a></div>
							<a href="/shop/${shop.id}">${shop.titleSh.namePub}</a>
							<div>Language: ${shop.shlang.lang }</div>
							<div>Year of publish: ${shop.shyear }</div>
							<div class="red">Price: ${shop.shprice }</div>
							<button type="button" class="btn btn-primary btn-xs">Buy</button>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>
</div>