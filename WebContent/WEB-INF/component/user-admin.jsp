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
    
	<div class="container-fluid tm-container-content tm-mt-60">
      <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">
            User Editor
          </button>
          <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">
            User Lists
          </button>
      
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
          <div class="row tm-mb-90 tm-gallery">
           

            <form class="mt-3">
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Username</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Password</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
               
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Fullname</label>
                    <input type="text" class="form-control" id="exampleInputPassword1">
                  </div>

                  <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="exampleInputPassword1">
                  </div>
              </form>


        
            <div class="form-floating">
             
              <br>
              <div class="d-flex align-items-center flex-row-reverse">
                <div class="button1">
                    <button type="button" class="btn btn-dark">Update</button>
                <button type="button" class="btn btn-dark">Delete</button>
                
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
        <div class="table-responsive-xxl">
            <table class="table">
                <thead>
                    <tr>
                      <th scope="col">Username</th>
                      <th scope="col">Password</th>
                      <th scope="col">Fullname</th>
                      <th scope="col">Email</th>
                      <th scope="col">Role</th>
                      <th scope="col">Action</th>
                    </tr>
                  </thead>
                  <tbody>
                   <c:forEach var="item" items="${items}">
				<tr>
					<th scope="row">${item.id }</th>
					<td>${item.password}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.role ? "Quản trị":"Nhân viên"}</td>
					<td><a href="${url}/edit/${item.id}">Edit</a></td>
				</tr>
			</c:forEach>
                  </tbody>
            </table>
            <div class="d-flex align-items-center flex-row-reverse">
                <div class="button1">
                    <button type="button" class="btn btn-dark"> |&lt; </button>
                <button type="button" class="btn btn-dark"> &lt;&lt; </button>
                <button type="button" class="btn btn-dark"> &gt;&gt; </button>
                <button type="button" class="btn btn-dark">&gt;|</button>
                </div>
              </div>
              <br>
          </div>
        </div>
      
      </div>
    </div>

	
	<jsp:include page="/WEB-INF/component/footer.jsp"></jsp:include>
    
    <script src="${pageContext.request.contextPath}/asset/js/plugins.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script>
        $(window).on("load", function() {
            $('body').addClass('loaded');
        });
    </script>
</body>
</html>