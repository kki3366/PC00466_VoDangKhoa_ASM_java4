<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url var="url" value="" />
<div class="container-fluid tm-mt-60">
      <div class="row tm-mb-50">
        <div class="col-lg-12 col-12 mb-5">
          <h2 class="tm-text-primary mb-5 text-center">Đăng nhập</h2>
         
          <form id="contact-form" action="${url}" method="POST" class="tm-contact-form mx-auto">
           <span class="tm-text-danger mb-5 text-center">${msg}</span>
            <div class="form-group">
              <input type="text" name="username" class="form-control rounded-0" placeholder="Username">
            </div>
            <div class="form-group">
              <input type="password" name="password" class="form-control rounded-0" placeholder="Password">
            </div>
            
            <div class="form-group tm-text-right">
              <button type="submit" class="btn btn-primary">Send</button>
            </div>
            <span class="tm-text-dark mb-5">Nếu bạn không có tài khoảng thì đăng kí tại đây:
              <a href="${pageContext.request.contextPath}/register" style="font-weight: bold;">Đăng kí</a></span>
          </form>
        </div>
      </div>
    </div>