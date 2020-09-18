<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<h1>Them loai sua</h1>
 <table class="table table-striped table-inverse table-responsive">
                          <thead class="thead-inverse text-primary">
                              <tr>
                                  <th>Mã loại</th>
                                  <th>Tên loại</th>
                              </tr>
                              </thead>
                              <tbody>
                            <c:forEach items="${ls}" var="ls">
                              <tr scope="row">
                                <td>${ls.maLoaiSua}</td>
                                <td>${ls.tenLoai}</td>
                             </tr>
                           </c:forEach>
                              </tbody>
                      </table>
<form action="them-san-pham" method="post">
  Ma loai sua<input type="text" name="txtMaLoai">
  Ten loai <input type="text" name="txtTen">
  <button type="submit">Them</button>
</form>