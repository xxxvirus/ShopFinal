<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style type="text/css">
.filter .control-label {
	text-align: left;
}

.filter span {
	display: block;
}
.photoAuthor{
	width: 230px;
    height: 350px;
    margin-top:15px;
}
.poster{
	width: 140px;
    height: 200px;
}
.titleA{
	font-size:30px;
}
</style>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<div><img src="/images/author/${author.id}.jpg" class="photoAuthor"></div>
		</div>
		<div class="col-md-9">
			<h3>${author.name} ${author.surname}</h3>
			<h3>Was born: ${author.yearOfBorn}</h3>
			<c:if test="${author.yearOfDead == 0}"></c:if>
			<c:if test="${author.yearOfDead != 0}">
			<h3>Was dead: ${author.yearOfDead}</h3>
			</c:if>
			<h3>Biography:</h3>
			<div><p>${author.biography}</p></div>
		</div>
	</div>
	<hr>
	<c:if test="${empty page.content}">
		<h3>books not found</h3>
	</c:if>
	<c:if test="${!empty page.content}">
		<div class="row">
		<div class="col-md-9"><h3>Author books:</h3></div>
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
			<form:form class="form-horizontal filter" action="/author/${author.id}"
				method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="_languageIds, _publisherIds, languageIds, publisherIds, max, min" />
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
				<c:if test="${shop.titleSh.book.author.id==author.id}">
					<div class="col-md-3">
						<div class="row">
							<div><a href="/shop/${shop.id}"><img src="/images/shop/${shop.id}.jpg" class="poster"></a></div>
							<a href="/shop/${shop.id}">${shop.titleSh.namePub}</a>
							<div>Language: ${shop.shlang.lang }</div>
							<div>Year of publish: ${shop.shyear }</div>
							<div class="red">Price: ${shop.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/author/${author.id}/addtocart/${shop.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	</c:if>
	<div class="row">
		<div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>
</div>