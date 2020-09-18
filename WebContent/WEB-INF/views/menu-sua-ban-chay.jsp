<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p>Danh sach sua ban chay</p>
<ul>
<c:forEach items="${sua}" var="s">
  <li><a href="sua-ban-chay?maSua=${s.maSua}">${s.tenSua}</a></li>
</c:forEach> 
</ul>