<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="userheadder.jsp"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="resources/product-images/${prolist.productId}.jpg" height="100" width="150"/>
<br>
productId:-${prolist.productId}
<br>
productName:-${prolist.productName}
<br>
productDescription:-${prolist.productDescription}
<br>
productPrice:-${prolist.productPrice}
<br>
productCategory:-${prolist.productCategory}
<br>
productSupplier:-${prolist.productSupplier}
<br>
supplierAddress:-${suplist.supplierAddress}
<br>
<form action="Cart" >
Quantity<input type="number" name="k">
<input type="number" name="s" value="${prolist.productId}" type="hidden">
<td><input type="submit" value=" AddToCart"></td>
</form>
<a href="=${prolist.productId}">BuyNow</a>
 </tr>
</table>
</body>
</html>