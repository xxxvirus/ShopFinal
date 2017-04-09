<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <h2>${publisher.name}</h2>
     <h3>Serias of publisher</h3>
     <ul>
     <c:forEach items="${serias}" var="seriaPub">
    	<li>${seriaPub.nameOfS}</li>
    </c:forEach>
    </ul><hr>
    <h3>Books of publisher</h3>
    <ul>
	    <c:forEach items="${shops}" var="shop">
	    	<li><a href="/book/${shop.shbook.id}">${shop.shbook.title}</a></li>
	    </c:forEach>
    </ul>