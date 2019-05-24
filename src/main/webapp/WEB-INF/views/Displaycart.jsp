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
<body>
<div class="container-fluid">
<div class="row">
<c:forEach items="${cartlist}" var="car">
<div class="col-sm-2">
<img src="resources/product-images/${car.productId}.jpg" height="100" width="150"/>
<br>
cartid:-${car.cartid}
<br>
productId:-${car.productId}
<br>
productName:-${car.productName}
<br>
productPrice:-${car.productPrice}
<br>
productSupplier:-${car.productSupplier}
<br>
quantity:-${car.quantity}
<br>
totalprice:-${car.totalprice}
<br>
</div>
</c:forEach>
</div>
</div>
<a href="=${prolist.productId}">BuyNow</a>
</body>
</html>