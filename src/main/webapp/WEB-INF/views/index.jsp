<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="text-center text-danger">CHI TIET</h1>
<form action="">
<div class="row">
	<div class="col-md-10"> 
      <input class="form-control" type="text" name="kw" placeholder="Nhap tu khoa"/>
    </div>
    <div class="col-md-2">
      <input type="submit" value="tim" class="btn btn-danger"/>
    </div>
</div>
</form>
<div class="row">
	<c:forEach var="p" items="${products}">
		<div class="card col-md-4">
			<div class="card-body">
				<img class="img-fluid"
					src="<c:url value='/resource/img/ip13.jpg' />">
			</div>
			<div class="card-footer">
				<h3>${p.name}</h3>
				<p>${p.price}</p>
			</div>
		</div>
	</c:forEach>
</div>