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
<c:url var="url" value="/Report" />
    <!-- Page Loader -->
    <div id="loader-wrapper">
        <div id="loader"></div>

        <div class="loader-section section-left"></div>
        <div class="loader-section section-right"></div>

    </div>
    
    <jsp:include page="/WEB-INF/component/navbar.jsp"></jsp:include>
<div class="container-fluid tm-container-content tm-mt-60">
      <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button class="nav-link" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="false">
            Favorites
          </button>
          <button class="nav-link active" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="true">
          Favorites User
          </button>
          <button class="nav-link" id="nav-share-tab" data-bs-toggle="tab" data-bs-target="#nav-share" type="button" role="tab" aria-controls="nav-share" aria-selected="false">
          Shared Friends
          </button>
      
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
          <div class="row tm-mb-90 tm-gallery">
            <div class="table-responsive-xxl">
                <table class="table">
                    <thead>
                        <tr>
                          <th scope="col">Video Title</th>
                          <th scope="col">Favorites Count</th>
                          <th scope="col">Latest Date</th>
                          <th scope="col">Oldest Date</th>
                        </tr>
                      </thead>
                      <tbody>
                       <c:forEach var="test1" items="${reports}">
				<tr>
					<th scope="row">${test1.group}</th>
					<th scope="row">${test1.likes}</th>
					<th scope="row">${test1.newest}</th>
					<th scope="row">${test1.oldest}</th>
				</tr>
			</c:forEach>
                       
                      </tbody>
                </table>
              
                  <br>
              </div>
          </div>
        </div>
       
        
        <div class="tab-pane fade active show" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
        <br>
        <form method="POST" action="${url}" id ="form1">
        <div class="d-flex align-items-center ">
            <div style="margin-right: 5rem;">
               <span style="white-space: nowrap;">Video Title</span>
            </div>
             
  				<select class="form-select" aria-label="Default select example" style="padding: 0px 20px;" name="test" onchange="submitmyForm()">
				<option value="" >--- Tên videos ---</option>  
                <c:forEach var="item" items="${requestScope.loadVideoinSelectBox}" >
                <option value="${item }" ${item == forwardToOldValue ?'selected':''  }>${item}</option>
               </c:forEach>
              </select>
            
          </div>
          <br>
        <div class="table-responsive-xxl">
            <table class="table">
                <thead>
                    <tr>
                      <th scope="col">Username</th>
                      <th scope="col">Email</th>
                      <th scope="col">Fullname</th>
                      <th scope="col">Favorites Date</th>

                    </tr>
                  </thead>
                  <tbody>
                 <c:forEach var="personWasLike" items="${personWasLike}">
				<tr>
					<th scope="row">${personWasLike.group}</th>
					<th scope="row">${personWasLike.email}</th>
					<th scope="row">${personWasLike.fullname}</th>
					<th scope="row">${personWasLike.favoriteDate}</th>
				</tr>
			</c:forEach>
                  </tbody>
            </table>
              <br>
          </div>
          </form>
        </div>
        
        <br>

        <div class="tab-pane fade" id="nav-share" role="tabpanel" aria-labelledby="nav-share-tab">
         <form method="POST" action="${url}" id ="form2">
        <div class="d-flex align-items-center ">
          </div>
          <br>
        <div class="table-responsive-xxl">
            <table class="table">
                <thead>
                    <tr>
                      <th scope="col">User Share</th>
                      <th scope="col">To Email</th>
                      <th scope="col">Sent Date</th>

                    </tr>
                  </thead>
                  <tbody>
                   <c:forEach var="personWasShare" items="${personWasShare}">
				<tr>
					<th scope="row">${personWasShare.fullname1}</th>
					<th scope="row">${personWasShare.toEmail}</th>
					<th scope="row">${personWasShare.dateShare1}</th>
				</tr>
			</c:forEach>
                   
                  </tbody>
            </table>
              <br>
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
    
     <script>
     function submitmyForm(){
    	 document.getElementById("form1").submit();
    	 }

     function submitmyForm1(){
    	 document.getElementById("form2").submit();
    	 }
	 console.log("'<%= request.getParameter("test") %>'")
    </script>
   
</body>
</html>