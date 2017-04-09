<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.poster {
	width: 140px;
	height: 200px;
}
</style>
<c:if test="${!empty qwer}">
	<div class=col-md-2>
		<div class="row"><a href="/makeorder"><button type="button" class="btn btn-success"
				style="margin-top: 8px;">Confirm</button></a></div>
		<div class="row">
			<c:set var="total" value="${0}"/>
				<c:forEach var="shop" items="${qwer}">
   				 <c:set var="total" value="${total + shop.shprice}" />
			</c:forEach>
			<h2>Total: ${total}</h2>
		</div>
	</div>
	
</c:if>
<div class="col-md-10">
	<c:forEach items="${qwer}" var="shop">
		<div class="col-md-3">
			<div class="row">
				<div>
					<a href="/shop/${shop.id}"><img
						src="/images/shop/${shop.id}.jpg" class="poster"></a>
				</div>
				<a href="/shop/${shop.id}">${shop.titleSh.namePub}</a>
				<div>
					<a href="/author/${shop.titleSh.book.author.id}">${shop.titleSh.book.author.name}
						${shop.titleSh.book.author.surname}</a>
				</div>
				<div>Language: ${shop.shlang.lang }</div>
				<div>Year of publish: ${shop.shyear }</div>
				<div class="red">Price: ${shop.shprice }</div>
				<form:form style="display:inline-block;margin-top:8px;"
					action="/deletefromcart/${shop.id}" method="POST">
					<button type="submit" class="btn btn-danger">Remove</button>
				</form:form>
			</div>
		</div>
	</c:forEach>
</div>