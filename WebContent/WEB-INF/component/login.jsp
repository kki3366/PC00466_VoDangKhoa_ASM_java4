<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:url var="url" value="" />
<div class="container-fluid tm-mt-60">
      <div class="row tm-mb-50">
        <div class="col-lg-12 col-12 mb-5">
          <h2 class="tm-text-primary mb-5 text-center">Đăng nhập</h2>
         <h6 class="tm-text-danger mb-2 text-center">${msg}</h6>
            <c:if test="${flag == true}">
              <h6 class="tm-text-danger mb-2 text-center"><a href="${pageContext.request.contextPath}/rememberPassword"  style="font-weight: bold;">Quên mật khẩu</a></h6>
              </c:if>
         
          <form id="contact-form" action="${url}" method="POST" class="tm-contact-form mx-auto">
           
            <div class="form-group">
              <input type="text" id="username" name="username" class="form-control rounded-0" style="${usernameValition}"placeholder="Username" oninvalid="customValation(this,'username');"  required>
            </div>
            <div class="form-group">
              <input type="password"  id="password" name="password" class="form-control rounded-0"  style="${passwordValition}" placeholder="Password" oninvalid="customValation(this,'password');"  required>
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
    
    <script>
	 function customValation(obj,id){
		 var test = document.getElementById(id).placeholder;
		 if(obj.value == ''){
			 obj.setCustomValidity("Không được để trống " + test);
			 }else if (obj.target.password = 'password' ){
				if(obj.value == ''){
					 obj.setCustomValidity("Không được để trống " + test);
					}
				 }
		 }
    </script>