<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="text-center text-danger">QUAN LY SAN PHAM</h1>
<c:url value="/admin/products" var="action" />
<form:form method="post" action="${action}" modelAttribute="product"
	enctype="multipart/form-data">
	<form:errors path="*" cssClass="alert alert-danger" element="div" />
	<div class="form-group">
		<label>Anh san pham</label>
		<form:input type="file" id="file" path="file" cssClass="form-control" />
		<form:errors path="name" cssClass="alert alert-danger" element="div" />
	</div>
	<div class="form-group">
		<label>Ten san pham</label>
		<form:input type="text" id="name" path="name" cssClass="form-control" />
	</div>
	<div class="form-group">
		<label>Mo ta</label>
		<form:textarea id="description" path="description"
			cssClass="form-control" />
	</div>
	<div class="form-group">
		<label>Gia</label>
		<form:input type="text" id="price" path="price"
			cssClass="form-control" />
		<form:errors path="price" cssClass="alert alert-danger" element="div" />
	</div>
	<div class="form-group">
		<input type="submit" value="Them san pham" class="btn btn-danger">
	</div>

</form:form>

