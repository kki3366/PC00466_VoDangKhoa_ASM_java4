<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <div class="container-fluid tm-mt-60">
      <div class="row tm-mb-50">
        <div class="col-lg-12 col-12 mb-5">
          <h2 class="tm-text-primary mb-5 text-center">Đăng kí</h2>
          <form id="contact-form" action="${url}" method="POST" class="tm-contact-form mx-auto" accept-charset="utf-8">
            <div class="form-group">
              <input type="text" id="username" name="id" class="form-control rounded-0" placeholder="Username" required pattern="[a-zA-Z0-9]+">
            </div>
            
            <div class="form-group">
              <input type="email" id="email" name="email" class="form-control rounded-0" placeholder="Email" required="" >
            </div>
            <div class="form-group">
              <input type="password" id="password" name="password" class="form-control rounded-0" placeholder="Password" required="" pattern="[a-zA-Z0-9]+">
            </div>
            <div class="form-group">
                <input type="password" id="CFpassword" name="confirmPassword" class="form-control rounded-0" placeholder="Confirm Password" required="" pattern="[a-zA-Z0-9]+">
              </div>
              <div class="form-group">
                <input type="text" name="fullname" class="form-control rounded-0" placeholder="Full Name" required="">
              </div>

            <div class="form-group tm-text-right">
              <button type="submit" class="btn btn-primary">Send</button>
            </div>
          </form>
        </div>
      </div>
    </div>