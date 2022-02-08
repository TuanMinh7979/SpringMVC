<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="text-center text-danger">QUAN LY SAN PHAM</h1>
<!--  
<c:url value="/admin/products" var="action" />
<c:if test="${errMsg!=null}">${errMsg}</c:if>
<form:form method="post" action="${action}" modelAttribute="product"
	enctype="multipart/form-data">



	<form:errors path="*" cssClass="alert alert-danger" element="div" />

	<div class="form-group">
		<label>Ten san pham</label>
		<form:input type="text" path="name" cssClass="form-control" />
		<form:errors path="name" cssClass="alert alert-danger" element="div" />
	</div>
	<div class="form-group">
		<label>Mo ta</label>
		<form:textarea path="description" cssClass="form-control"></form:textarea>
	</div>
	<div class="form-group">
		<label>Gia</label>
		<form:input type="text" path="price" cssClass="form-control" />
		<form:errors path="price" cssClass="alert alert-danger" element="div" />
	</div>

	<div class="form-group">
		<label>Danh muc</label>
		<form:select type="text" path="category1" cssClass="form-control">
			<c:forEach items="${categories}" var="cat">
				<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</form:select>
		<form:errors path="category1" cssClass="alert alert-danger"
			element="div" />
	</div>

	<div class="form-group">
		<label>Anh san pham</label>
		<form:input type="file" path="file" cssClass="form-control" />
	</div>


	<div class="form-group">
		<input type="submit" value="Them san pham" class="btn btn-danger">
	</div>

</form:form>
-->

