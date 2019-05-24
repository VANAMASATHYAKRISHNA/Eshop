<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@include file="adminheadder.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<table  border="2">
<tr>
<th>
ProductId
</th>
<th>
ProductName
</th>
<th>
ProductDiscription
</th>
<th>
ProductPrice
</th>
<th>
ProductCategory
</th>
<th>
ProductSupplier
</th>
<th>
Product Images
</th>
<th>
Delete
</th>
<th>
Edit
</th>
</tr>
<body>
<c:forEach items="${prolist}" var="pro">
<tr>
<td>${pro.productId}</td>
<td>${pro.productName}</td>
<td>${pro.productDescription}</td>
<td>${pro.productPrice}</td>
<td>${pro.productCategory}</td>
<td>${pro.productSupplier}</td>
<td><img src="resources/product-images/${pro.productId}.jpg" height="100" width="150"/>
<td> <a href="pedit?proId=${pro.productId}">edit</a></td>
<td> <a href="pdel?proId=${pro.productId}">delete</a></td>
</c:forEach>
</table>
</body>
</html>