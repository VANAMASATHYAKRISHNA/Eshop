<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="adminheadder.jsp"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addsup" method="post" modelAttribute="sup">
SupplierName <sform:input  path="supplierName" />
SupplierDetails <sform:input  path="supplierDetails" />
SupplierAddress<sform:input path="supplierAddress"/>
<sform:input  path="supplierId" type="hidden" />
<input type="submit"value="${ButtonName }"/>
</sform:form>
</body>
</html>