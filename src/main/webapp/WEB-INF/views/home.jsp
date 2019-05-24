<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="adminheadder.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
</head>
<body>
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
    <li data-target="#myCarousel" data-slide-to="6"></li>
    <li data-target="#myCarousel" data-slide-to="7"></li>
    
    
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="resources/crsl-images/1.png" height="1080" width="1080">
    </div>

    <div class="item">
      <img src="resources/crsl-images/2.png" height="1080" width="1080">
    </div>

    <div class="item">
      <img src="resources/crsl-images/3.png" height="1080" width="1080">
    </div>
    <div class="item">
      <img src="resources/crsl-images/4.png" height="1080" width="1080">
    </div>
    <div class="item">
      <img src="resources/crsl-images/5.png" height="1080" width="1080">
    </div>
    <div class="item">
      <img src="resources/crsl-images/6.png" height="1080" width="1080">
    </div>
    <div class="item">
      <img src="resources/crsl-images/7.png" height="1080" width="1080">
    </div>
    <div class="item">
      <img src="resources/crsl-images/8.png" height="1080" width="2180">
    </div>
    
  </div>
 <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
</body>
</html>