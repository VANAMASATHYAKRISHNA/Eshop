<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Carts</title>
</head>
<table  border="2">
<tr>
<th>
cartid
</th>
<th>
productId
</th>
<th>
productName
</th>
<th>
productPrice
</th>
<th>
productSupplier
</th>
<th>
Quantity
</th>
<th>
Totalprice
</th>
<th>
Product-Image
</th>
</tr>
<body>
<c:forEach items="${cartlist}" var="car">
<tr>
<td>${car.cartid}</td>
<td>${car.productId}</td>
<td>${car.productName}</td>
<td>${car.productPrice}</td>
<td>${car.productSupplier}</td>
<td>${car.quantity}</td>
<td>${car.totalprice}</td>
<td><img src="resources/product-images/${car.productId}.jpg" height="100" width="150"/></td></tr>
</c:forEach>
</table>
</body>
</html>