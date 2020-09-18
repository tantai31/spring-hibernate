<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<form class="form-inline" action="tim-kiem-sua" action="get">
     Hãng sữa
    <select name="cboHangSua">
     <c:forEach items="${sessionScope.hs}" var="hs">
      <option value="${hs.maHangSua}">${hs.tenHangSua}</option>
     </c:forEach>
     </select>    
     Loại sữa
     <select name="cboLoaiSua">
      <c:forEach items="${sessionScope.ls}" var="ls">
      <option value="${ls.maLoaiSua}">${ls.tenLoai}</option>
     </c:forEach>
     </select>
     <div class="input-group mb-2 mr-sm-2">
        <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Tên sữa" name="txtTenSua">
      </div>      
    <button type="submit" class="btn btn-primary mb-2 btn-sm" name="btnTim">Search</button>
</form> 
<c:if test="${s.size() > 0 }">
Co ${s.size()} san pham duoc tim thay
<table class="table table-striped table-inverse table-responsive">
                          <thead class="thead-inverse text-primary text-nowcrap">
                              <tr>
                                  <th>Hình</th>
                                  <th>Tên sữa</th>
                                  <th>Đơn giá</th>
                                  <th>Trọng lượng</th>
                                  <th>Thành phần dinh dưỡng</th>
                                  <th>Lợi ích</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${s}" var="s">
                                  <tr>
                                      <td scope="row"><img src="images/${s.hinh}"></td>
                                      <td>${s.tenSua}</td>
                                      <fmt:setLocale value="vi-VN"/>
                                      <fmt:formatNumber value="${s.donGia}" var="donGia" type="number"/>
                                      <td>${donGia} VND</td>
                                      <td>${s.trongLuong}</td>
                                      <td>${s.tpDinhDuong}</td>
                                      <td>${s.loiIch}</td>
                                      <td><a class="btn btn-info" href="javascript:them('${s.maSua}','1')">Thêm vào giỏ</a></td>
                                  </tr>
                                </c:forEach>
                              </tbody>
</table>
</c:if>