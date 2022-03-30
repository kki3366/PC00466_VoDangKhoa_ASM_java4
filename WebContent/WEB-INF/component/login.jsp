<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="container-fluid tm-mt-60">
      <div class="row tm-mb-50">
        <div class="col-lg-12 col-12 mb-5">
          <h2 class="tm-text-primary mb-5 text-center">Đăng nhập</h2>
          
          <form id="contact-form" action="" method="POST" class="tm-contact-form mx-auto">
            <div class="form-group">
              <input type="text" name="username" class="form-control rounded-0" placeholder="Username" required="">
            </div>
            <div class="form-group">
              <input type="password" name="password" class="form-control rounded-0" placeholder="Password" required="">
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