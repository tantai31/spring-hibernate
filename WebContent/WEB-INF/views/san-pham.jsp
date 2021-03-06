<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="js/them.js" type="text/javascript"></script>
<style>
    .card{
        width:18rem;
        float: left;
        margin: 0.5rem;
        color: red;
        height: 300px;
    }
    .card-text{
        color: aqua;
    }
</style>
<c:forEach items="${sua}" var="s">
<div class="card border-danger text-center">
    <img class="card-img-top" src="${pageContext.request.contextPath}/images/${s.hinh}" alt="">
         <div class="card-body">
             <h4 class="card-title">${s.tenSua}</h4>
             <fmt:setLocale value="vi-VN"/>
             <fmt:formatNumber value="${s.donGia}" var="donGia" type="number"/>
              <p class="card-text">${donGia} VND</p>
         </div>
         <div class="card-footer">
             <a href="chi-tiet-san-pham?maSua=${s.maSua}" class="btn btn-info">Chi tiết</a>
             <a class="btn btn-info" href="javascript:them('${s.maSua}','1')">Thêm giỏ</a>
         </div>
</div>
</c:forEach>
<div  style="clear:both"></div>
<div style="text-align: center"> 

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center pagination-sm">
          <li class="page-item disabled">
            <a class="page-link" href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
              <span class="sr-only">Previous</span>
            </a>
          </li>
          <c:forEach var="i" end="${total}" begin="1" step="1">
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/${i}">${i}</a></li>
          </c:forEach>
          <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
              <span class="sr-only">Next</span>
            </a>
          </li>
        </ul>
      </nav>
</div>