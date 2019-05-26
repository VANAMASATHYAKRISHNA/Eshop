<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@include file="userheadder.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<sform:form action="loginsuc"  method="post" modelAttribute="reg">
Email<sform:input path="email"/>
<br>
Password<sform:input path="password"/>
<br>
<input type="submit"value="submit"/>
</sform:form>
${loginfo}
</body>
</html>