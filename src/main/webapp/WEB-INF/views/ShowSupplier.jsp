<%@page import="java.util.List"%>
<%@page import="com.sathya.model.Supplier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="adminheadder.jsp"%>
<%@page isELIgnored="false" %>
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
SupplierId
</th>
<th>
SupplierName
</th>
<th>
SupplierDetails
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>
<body>
<c:forEach items="${suplist}" var="sup">
<tr>
<td>${sup.supplierId}</td>
<td>${sup.supplierName}</td>
<td>${sup.supplierDetails}</td>
<td><a href="sedit?supId=${sup.supplierId}">Edit</a></td>
<td><a href="sdel?supId=${sup.supplierId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>