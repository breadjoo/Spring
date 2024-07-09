<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@ include file="include/header.jsp" %>

<h4>${exception.getMessage()} </h4>

<ul>
<C:forEach items="${exception.getStackTrace()}"  var="stack">
	<li>${stack.toString()}	</li>
</C:forEach>

</ul>

<%@ include file="include/footer.jsp" %>