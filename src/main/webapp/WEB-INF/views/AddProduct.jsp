<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="adminheadder.jsp"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addpro"  method="post" modelAttribute="pro" enctype="multipart/form-data">
ProductName <sform:input  path="productName"  />
ProductDiscription <sform:input  path="productDescription" />
ProductPrice <sform:input  path="productPrice" />
ProductCategory<sform:select path="ProductCategory">
<sform:option value="cate">ProductCategory</sform:option>
<c:forEach items="${catlist}" var="cat">
<sform:option value="${cat.categoryName}">${cat.categoryName}</sform:option>
</c:forEach>
</sform:select>
ProductSupplier<sform:select path="productSupplier">
<sform:option value="supli">ProductSupplier</sform:option>
<c:forEach items="${suplist}" var="sup">
<sform:option value="${sup.supplierName}">${sup.supplierName}</sform:option>
</c:forEach>
</sform:select>
ProductImage<sform:input type="file" path="proimg"/>
ProductID <sform:input  path="productId" type="hidden" />
<input type="submit"value="${ButtonName}"/>
</sform:form>
</body>
</html>