<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catalog-Z Bootstrap 5.0 HTML Template</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/templatemo-style.css">
<!--
    
TemplateMo 556 Catalog-Z

https://templatemo.com/tm-556-catalog-z

-->
<style type="text/css">
${css}
</style>
</head>
<body>
<c:url var="url" value="/ChangePassword" />
    <!-- Page Loader -->
    <div id="loader-wrapper">
        <div id="loader"></div>

        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>

    </div>
    
    <jsp:include page="/WEB-INF/component/navbar.jsp"></jsp:include>

    <div class="tm-hero d-flex justify-content-center align-items-center" data-parallax="scroll" data-image-src="${pageContext.request.contextPath}/asset/img/hero.jpg">
        <form class="d-flex tm-search-form">
            <input class="form-control tm-search-input" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success tm-search-btn" type="submit">
                <i class="fas fa-search"></i>
            </button>
        </form>
    </div>
    
    
    <div class="container-fluid tm-mt-60">
      <div class="row tm-mb-50">
        <div class="col-lg-12 col-12 mb-5">
          <h2 class="tm-text-primary mb-5 text-center">Đổi mật khẩu</h2>
          <form id="contact-form" action="${url}" method="POST" class="tm-contact-form mx-auto">
          <mark>${msg }</mark>
            <div class="form-group">
                <input type="password" name="oldPassword" class="form-control rounded-0" placeholder="Old Password" required="" pattern="[a-zA-Z0-9]+">
              </div>
              <div class="form-group">
                <input type="password" name="newPassword" class="form-control rounded-0" placeholder="New Password" required="" pattern="[a-zA-Z0-9]+">
              </div>

              <div class="form-group">
                <input type="password" name="confirmNewPassword" class="form-control rounded-0" placeholder="Confirm Password" required="" pattern="[a-zA-Z0-9]+">
              </div>
            

            <div class="form-group tm-text-right">
              <button type="submit" class="btn btn-primary">Send</button>
            </div>
          </form>
        </div>
      </div>
    </div>
    

	
	<jsp:include page="/WEB-INF/component/footer.jsp"></jsp:include>
    
    <script src="${pageContext.request.contextPath}/asset/js/plugins.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script>
        $(window).on("load", function() {
            $('body').addClass('loaded');
        });
    </script>
   
</body>
</html>