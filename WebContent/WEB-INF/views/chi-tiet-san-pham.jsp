<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1px">
 <caption>${s.tenSua}</caption>
  <tr>
     <td><img src="images/${s.hinh}"></td>
     <td>${s.loiIch}</td>             
  </tr>
  <tr>
     <td>${s.donGia}  ${s.trongLuong}</td>
     <td>${s.tpDinhDuong}</td>
  </tr>
</table>
