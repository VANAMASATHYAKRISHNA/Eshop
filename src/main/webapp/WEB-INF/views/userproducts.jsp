<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="userheadder.jsp"%>
<!DOCTYPE html>
<html>
<head>
<body>
<div class="container-fluid">
<div class="row">
<c:forEach items="${prolist}" var="pro">
<div class="col-sm-2">
<img src="resources/product-images/${pro.productId}.jpg" height="100" width="150"/>
<br>
Product Id:<td>${pro.productId}</td>
<br>
Product Name:<td>${pro.productName}</td>
<br>
productDescription:<td>${pro.productDescription}</td>
<br>
productPrice:<td>${pro.productPrice}</td>
<br>
productCategory:<td>${pro.productCategory}</td>
<br>
pro.productSupplier:<td>${pro.productSupplier}</td>
<br>
<td> <a href="viewdetails?proId=${pro.productId}">ViewDetails</a></td>
<br>
</div>
</c:forEach>
</div>
</div>
</body>
</html>