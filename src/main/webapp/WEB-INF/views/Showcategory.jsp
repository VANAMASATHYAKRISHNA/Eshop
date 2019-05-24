<%@page import="com.sathya.model.Category"%>
<%@page import="java.util.List"%>
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
<table  border="1">
<tr>
<th>
CategoryId
</th>
<th>
CategoryName
</th>
<th>
CategoryDiscription
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>
<body>
<c:forEach items="${catlist}" var="cat">
<tr>
<td>${cat.categoryId}</td>
<td>${cat.categoryName}</td>
<td>${cat.categoryDiscription}</td>
<td><a href="edit?catId=${cat.categoryId}">Edit</a></td>
<td><a href="del?catId=${cat.categoryId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>