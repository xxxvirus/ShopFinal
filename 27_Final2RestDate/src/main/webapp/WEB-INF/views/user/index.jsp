<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<style>
.indexMenu {
	border-right: 1px solid #ccc;
}
.poster{
	width: 140px;
    height: 200px;
}
.carousel {
    margin-bottom: 0;
    padding: 0 40px 30px 40px;
}
/* The controlsy */
.carousel-control {
	left: -12px;
    height: 40px;
	width: 40px;
    background: none repeat scroll 0 0 #222222;
    border: 4px solid #FFFFFF;
    border-radius: 23px 23px 23px 23px;
    margin-top: 90px;
}
.carousel-control.right {
	right: -12px;
}
/* The indicators */
.carousel-indicators {
	right: 50%;
	top: auto;
	bottom: -10px;
	margin-right: -19px;
}
/* The colour of the indicators */
.carousel-indicators li {
	background: #cecece;
}
.carousel-indicators .active {
background: #428bca;
}
</style>
<script>
$(document).ready(function() {
    $('#myCarousel').carousel({
	    interval: 10000
	})
});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3 indexMenu">
			<h2>Category</h2>
			<c:forEach items="${categories}" var="category">
				<div class="row">
					<a href="/category/${category.id}">${category.nameOfC}</a>
				</div>
			</c:forEach>
			<hr>
		</div>
		<div class="col-md-9">
			<div class="col-md-12">
				<h2>New!!</h2>
				<div class="row">
					<div id="Carousel" class="carousel slide">
					<ol class="carousel-indicators">
	                    <li data-target="#Carousel" data-slide-to="0" class="active"></li>
	                    <li data-target="#Carousel" data-slide-to="1"></li>
	                    <li data-target="#Carousel" data-slide-to="2"></li>
	                </ol>
	                <div class="carousel-inner">
	                <div class="item active">
	                <div class="row-fluid">
						<div class="col-md-3">
							<div><a href="/shop/${first.id}"><img src="/images/shop/${first.id}.jpg" class="poster"></a></div>
							<a href="/shop/${first.id}">${first.titleSh.namePub}</a>
							<div><a href="/author/${first.titleSh.book.author.id}">${first.titleSh.book.author.name} ${first.titleSh.book.author.surname}</a></div>
							<div>Language: ${first.shlang.lang }</div>
							<div>Year of publish: ${first.shyear }</div>
							<div class="red">Price: ${first.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${first.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${second.id}"><img src="/images/shop/${second.id}.jpg" class="poster"></a></div>
							<a href="/shop/${second.id}">${second.titleSh.namePub}</a>
							<div><a href="/author/${second.titleSh.book.author.id}">${second.titleSh.book.author.name} ${second.titleSh.book.author.surname}</a></div>
							<div>Language: ${second.shlang.lang }</div>
							<div>Year of publish: ${second.shyear }</div>
							<div class="red">Price: ${second.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${second.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${third.id}"><img src="/images/shop/${third.id}.jpg" class="poster"></a></div>
							<a href="/shop/${third.id}">${third.titleSh.namePub}</a>
							<div><a href="/author/${third.titleSh.book.author.id}">${third.titleSh.book.author.name} ${third.titleSh.book.author.surname}</a></div>
							<div>Language: ${third.shlang.lang }</div>
							<div>Year of publish: ${third.shyear }</div>
							<div class="red">Price: ${third.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${third.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${fourth.id}"><img src="/images/shop/${fourth.id}.jpg" class="poster"></a></div>
							<a href="/shop/${fourth.id}">${fourth.titleSh.namePub}</a>
							<div><a href="/author/${fourth.titleSh.book.author.id}">${fourth.titleSh.book.author.name} ${fourth.titleSh.book.author.surname}</a></div>
							<div>Language: ${fourth.shlang.lang }</div>
							<div>Year of publish: ${fourth.shyear }</div>
							<div class="red">Price: ${fourth.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${fourth.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
					</div>
					</div>
					<div class="item">
	                <div class="row-fluid">
						<div class="col-md-3">
							<div><a href="/shop/${first.id}"><img src="/images/shop/${first.id}.jpg" class="poster"></a></div>
							<a href="/shop/${first.id}">${first.titleSh.namePub}</a>
							<div><a href="/author/${first.titleSh.book.author.id}">${first.titleSh.book.author.name} ${first.titleSh.book.author.surname}</a></div>
							<div>Language: ${first.shlang.lang }</div>
							<div>Year of publish: ${first.shyear }</div>
							<div class="red">Price: ${first.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${first.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${second.id}"><img src="/images/shop/${second.id}.jpg" class="poster"></a></div>
							<a href="/shop/${second.id}">${second.titleSh.namePub}</a>
							<div><a href="/author/${second.titleSh.book.author.id}">${second.titleSh.book.author.name} ${second.titleSh.book.author.surname}</a></div>
							<div>Language: ${second.shlang.lang }</div>
							<div>Year of publish: ${second.shyear }</div>
							<div class="red">Price: ${second.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${second.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${third.id}"><img src="/images/shop/${third.id}.jpg" class="poster"></a></div>
							<a href="/shop/${third.id}">${third.titleSh.namePub}</a>
							<div><a href="/author/${third.titleSh.book.author.id}">${third.titleSh.book.author.name} ${third.titleSh.book.author.surname}</a></div>
							<div>Language: ${third.shlang.lang }</div>
							<div>Year of publish: ${third.shyear }</div>
							<div class="red">Price: ${third.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${third.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${fourth.id}"><img src="/images/shop/${fourth.id}.jpg" class="poster"></a></div>
							<a href="/shop/${fourth.id}">${fourth.titleSh.namePub}</a>
							<div><a href="/author/${fourth.titleSh.book.author.id}">${fourth.titleSh.book.author.name} ${fourth.titleSh.book.author.surname}</a></div>
							<div>Language: ${fourth.shlang.lang }</div>
							<div>Year of publish: ${fourth.shyear }</div>
							<div class="red">Price: ${fourth.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${fourth.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
					</div>
					</div>
					</div>
					<a data-slide="prev" href="#Carousel" class="left carousel-control">‹</a>
	                <a data-slide="next" href="#Carousel" class="right carousel-control">›</a>
					</div>
				</div>
				<hr>
			</div>
			<div class="col-md-12">
				<h2>Popular!</h2>
				<div class="row">
				<div id="Carousel2" class="carousel slide">
					<ol class="carousel-indicators">
	                    <li data-target="#Carousel" data-slide-to="0" class="active"></li>
	                    <li data-target="#Carousel" data-slide-to="1"></li>
	                    <li data-target="#Carousel" data-slide-to="2"></li>
	                </ol>
	                <div class="carousel-inner">
	                <div class="item active">
	                <div class="row-fluid">
						<div class="col-md-3">
							<div><a href="/shop/${first.id}"><img src="/images/shop/${first.id}.jpg" class="poster"></a></div>
							<a href="/shop/${first.id}">${first.titleSh.namePub}</a>
							<div><a href="/author/${first.titleSh.book.author.id}">${first.titleSh.book.author.name} ${first.titleSh.book.author.surname}</a></div>
							<div>Language: ${first.shlang.lang }</div>
							<div>Year of publish: ${first.shyear }</div>
							<div class="red">Price: ${first.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${first.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${second.id}"><img src="/images/shop/${second.id}.jpg" class="poster"></a></div>
							<a href="/shop/${second.id}">${second.titleSh.namePub}</a>
							<div><a href="/author/${second.titleSh.book.author.id}">${second.titleSh.book.author.name} ${second.titleSh.book.author.surname}</a></div>
							<div>Language: ${second.shlang.lang }</div>
							<div>Year of publish: ${second.shyear }</div>
							<div class="red">Price: ${second.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${second.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${third.id}"><img src="/images/shop/${third.id}.jpg" class="poster"></a></div>
							<a href="/shop/${third.id}">${third.titleSh.namePub}</a>
							<div><a href="/author/${third.titleSh.book.author.id}">${third.titleSh.book.author.name} ${third.titleSh.book.author.surname}</a></div>
							<div>Language: ${third.shlang.lang }</div>
							<div>Year of publish: ${third.shyear }</div>
							<div class="red">Price: ${third.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${third.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${fourth.id}"><img src="/images/shop/${fourth.id}.jpg" class="poster"></a></div>
							<a href="/shop/${fourth.id}">${fourth.titleSh.namePub}</a>
							<div><a href="/author/${fourth.titleSh.book.author.id}">${fourth.titleSh.book.author.name} ${fourth.titleSh.book.author.surname}</a></div>
							<div>Language: ${fourth.shlang.lang }</div>
							<div>Year of publish: ${fourth.shyear }</div>
							<div class="red">Price: ${fourth.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${fourth.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
					</div>
					</div>
					<div class="item">
	                <div class="row-fluid">
						<div class="col-md-3">
							<div><a href="/shop/${first.id}"><img src="/images/shop/${first.id}.jpg" class="poster"></a></div>
							<a href="/shop/${first.id}">${first.titleSh.namePub}</a>
							<div><a href="/author/${first.titleSh.book.author.id}">${first.titleSh.book.author.name} ${first.titleSh.book.author.surname}</a></div>
							<div>Language: ${first.shlang.lang }</div>
							<div>Year of publish: ${first.shyear }</div>
							<div class="red">Price: ${first.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${first.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${second.id}"><img src="/images/shop/${second.id}.jpg" class="poster"></a></div>
							<a href="/shop/${second.id}">${second.titleSh.namePub}</a>
							<div><a href="/author/${second.titleSh.book.author.id}">${second.titleSh.book.author.name} ${second.titleSh.book.author.surname}</a></div>
							<div>Language: ${second.shlang.lang }</div>
							<div>Year of publish: ${second.shyear }</div>
							<div class="red">Price: ${second.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${second.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${third.id}"><img src="/images/shop/${third.id}.jpg" class="poster"></a></div>
							<a href="/shop/${third.id}">${third.titleSh.namePub}</a>
							<div><a href="/author/${third.titleSh.book.author.id}">${third.titleSh.book.author.name} ${third.titleSh.book.author.surname}</a></div>
							<div>Language: ${third.shlang.lang }</div>
							<div>Year of publish: ${third.shyear }</div>
							<div class="red">Price: ${third.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${third.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
						<div class="col-md-3">
							<div><a href="/shop/${fourth.id}"><img src="/images/shop/${fourth.id}.jpg" class="poster"></a></div>
							<a href="/shop/${fourth.id}">${fourth.titleSh.namePub}</a>
							<div><a href="/author/${fourth.titleSh.book.author.id}">${fourth.titleSh.book.author.name} ${fourth.titleSh.book.author.surname}</a></div>
							<div>Language: ${fourth.shlang.lang }</div>
							<div>Year of publish: ${fourth.shyear }</div>
							<div class="red">Price: ${fourth.shprice }</div>
							<sec:authorize access="isAuthenticated()"><form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtocart/${fourth.id}" method="POST">
								<button type="submit" class="btn btn-success">Buy</button>
							</form:form></sec:authorize>
						</div>
					</div>
					</div>
					</div>
					<a data-slide="prev" href="#Carousel2" class="left carousel-control">‹</a>
	                <a data-slide="next" href="#Carousel2" class="right carousel-control">›</a>
					</div>
				</div>
				<hr>
			</div>
		</div>
	</div>
</div>
