<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="adminheadder.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
   <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<sform:form action="register"  method="post" modelAttribute="reg">
Email<sform:input path="email"/>
<br>
Password<sform:input path="password"/>
<br>
UserName<sform:input path="username"/>
<br>
MobileNumber<sform:input path="mobilenumber"/>
<br>
Address<sform:input path="address"/>
<br>
<input type="submit"value="submit"/>
</sform:form>
</body>
</html>