<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style>
.poster{
	width: 140px;
    height: 200px;
}
.filter .control-label {
	text-align: left;
}

.filter span {
	display: block;
}
</style>
<h2>${category.nameOfC}</h2>
<c:if test="${category.id==1}">
	<div class="row">
		<div class="col-md-12">
			<h2>Popular author</h2>
				<div class="row">
					<div class="col-md-3">
						<div><a href="/author/${firstAuthor.id}"><img src="/images/author/${firstAuthor.id}.jpg" class="poster"></a></div>
						<a href="/author/${firstAuthor.id}">${firstAuthor.name} ${firstAuthor.surname}</a>
					</div>
					<div class="col-md-3">
						<div><a href="/author/${secondAuthor.id}"><img src="/images/author/${secondAuthor.id}.jpg" class="poster"></a></div>
						<a href="/author/${secondAuthor.id}">${secondAuthor.name} ${secondAuthor.surname}</a>
					</div>
				</div>
				<hr>
		</div>
		<div class="col-md-12">
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
		</div>
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
					<form:form class="form-horizontal filter" action="/category/${category.id}"
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
						<c:if test="${shop.shcat.id==category.id}">
							<div class="col-md-3">
								<div class="row">
										<div><a href="/shop/${shop.id}"><img src="/images/shop/${shop.id}.jpg" class="poster"></a></div>
										<a href="/shop/${shop.id}">${shop.titleSh.namePub}</a>
										<div>Language: ${shop.shlang.lang }</div>
										<div>Year of publish: ${shop.shyear }</div>
										<div class="red">Price: ${shop.shprice }</div>
										<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/category/${category.id}/addtocart/${shop.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="row">
					<div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>
			</div>
		</div>
	</div>
</c:if>
