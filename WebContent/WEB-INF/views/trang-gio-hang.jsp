<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<table class="table table-striped table-inverse table-responsive">
                          <thead class="thead-inverse text-primary text-nowcrap">
                              <tr>
                                  <th>Hình</th>
                                  <th>Tên sữa</th>
                                  <th>Đơn giá</th>
                                  <th>Trọng lượng</th>
                                  <th>Số lượng</th>
                                  <th>Tổng tiền</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach items="${sessionScope.gioHang.danhSachGioHang()}" var="s">
                                  <tr>
                                      <td scope="row"><img src="images/${s.hinh}"></td>
                                      <td>${s.tenSua}</td>
                                      <fmt:setLocale value="vi-VN"/>
                                      <fmt:formatNumber value="${s.donGia}" var="donGia" type="number"/>
                                      <td>${donGia} VND</td>
                                      <td>${s.trongLuong}</td>
                                      <td>${s.soLuongMua}</td>
                                      <fmt:setLocale value="vi-VN"/>
                                      <fmt:formatNumber value="${s.thanhTien()}" var="thanhTien" type="number"/>
                                      <td>${thanhTien} VND</td>
                                  </tr>
                                </c:forEach>
                              </tbody>
</table>
<table class="table table-striped table-inverse table-responsive text-nowcrap">
                          <thead class="thead-inverse text-primary">
                              <tr>
                                  <th>Thành tiền</th>
                                  <th>Phí ship</th>
                                  <th>Tổng tiền</th>
                              </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                     <fmt:setLocale value="vi-VN"/>
                                     <fmt:formatNumber value="${sessionScope.gioHang.tongTien()}" var="tongTien" type="number"/> 
                                      <td scope="row">${tongTien} VND</td>
                                      <td>0.0</td>
                                      <td>${tongTien} VND</td>
                                  </tr>
                              </tbody>
 </table>
