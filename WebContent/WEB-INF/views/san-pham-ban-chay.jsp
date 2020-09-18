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
                                  <th>Thành phần dinh dưỡng</th>
                                  <th>Lợi ích</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
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
                              </tbody>
</table>
