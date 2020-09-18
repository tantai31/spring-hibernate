<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <script src="js/them.js" type="text/javascript"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
        <li><a href="sua-ban-chay">Sữa bán chạy</a></li>
        <li><a href="tim-kiem-sua">Tìm kiếm sữa</a></li>
        <li><a href="them-san-pham">Thêm sữa</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <c:if test="${sessionScope.nguoidung==null}">
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </c:if>
        <c:if test="${sessionScope.nguoidung!=null}">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     <tiles:insertAttribute name="thucDon"/>
    </div>
    <div class="col-sm-8 text-left"> 
     <tiles:insertAttribute name="noiDung"/>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <fmt:setLocale value="vi-VN"/>
        <fmt:formatNumber value="${sessionScope.gioHang.tongTien()}" var="tongTien" type="number"/>
        <a href="trang-gio-hang">Giỏ hàng: <span class="cart-amunt" id="tongSoTien">${tongTien}</span> <i class="fa fa-shopping-cart"></i> <span class="product-count" id="soMatHang" >${sessionScope.gioHang.soMatHang()}</span></a>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
