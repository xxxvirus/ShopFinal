<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
.poster{
	width: 140px;
    height: 200px;
}
</style>
<div class="container-fluid">


	<c:forEach items="${page.content}" var="shop">
		<div class="row">
			<div class="col-md-2">
				<a href="/shop/${shop.id}"><img src="/images/shop/${shop.id}.jpg" class="poster"></a>
			</div>
			<div class="col-md-4">
				<div><a href="/shop/${shop.id}">${shop.titleSh.namePub}</a></div>
				<div><a href="/author/${shop.titleSh.book.author.id}">${shop.titleSh.book.author.name} ${shop.titleSh.book.author.surname}</a></div>
				<div><b>Language:</b> ${shop.shlang.lang }</div>
				<div><b>Year of publish:</b> ${shop.shyear }</div>
				<div><b>Anotation:</b></div>
				<div>${shop.anotation }</div>
			</div>
		</div>
	</c:forEach>
</div>