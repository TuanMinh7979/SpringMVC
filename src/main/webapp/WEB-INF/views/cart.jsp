<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="text-center text-danger">GIO HANG</h1>
<table class="table">
	
	<tr>
		<th>Ma San pham</th>
		<th>Ten San pham</th>
		<th>Don gia</th>
		<th>So luong</th>
	</tr>

	<c:forEach var="c" items="${carts}">
		<tr>
			<td>${c.productId}</td>
			<td>${c.name}</td>
			<td>${c.price}</td>
			<td>${c.count}</td>

		</tr>
	</c:forEach>

</table>