<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p>Danh sach theo hang sua</p>
<ul>
<c:forEach items="${sessionScope.hs}" var="hs">
  <li><a href="hang-sua?maHang=${hs.maHangSua}&p=1">${hs.tenHangSua}</a></li>
</c:forEach> 
</ul>
<p>Danh sach theo loai sua</p>
<ul>
<c:forEach items="${sessionScope.ls}" var="ls">
  <li><a href="loai-sua?maLoai=${ls.maLoaiSua}&p=1">${ls.tenLoai}</a></li>
</c:forEach>
</ul>