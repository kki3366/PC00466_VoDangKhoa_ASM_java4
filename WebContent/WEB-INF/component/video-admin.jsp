<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Catalog-Z Bootstrap 5.0 HTML Template</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/fontawesome/css/all.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/templatemo-style.css" />
    <!--
    
TemplateMo 556 Catalog-Z

https://templatemo.com/tm-556-catalog-z

-->
  </head>
  <body>
  <c:url var="url" value="/videoAdmin" />
    <!-- Page Loader -->
    <div id="loader-wrapper">
      <div id="loader"></div>

      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
    </div>
 <jsp:include page="/WEB-INF/component/navbar.jsp"></jsp:include>
    <div
      class="tm-hero d-flex justify-content-center align-items-center"
      data-parallax="scroll"
      data-image-src="${pageContext.request.contextPath}/asset/img/hero.jpg"
    >
      <form class="d-flex tm-search-form">
        <input
          class="form-control tm-search-input"
          type="search"
          placeholder="Search"
          aria-label="Search"
        />
        <button class="btn btn-outline-success tm-search-btn" type="submit">
          <i class="fas fa-search"></i>
        </button>
      </form>
    </div>

    <div class="container-fluid tm-container-content tm-mt-60">
      <nav>
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button
            class="nav-link active"
            id="nav-home-tab"
            data-bs-toggle="tab"
            data-bs-target="#nav-home"
            type="button"
            role="tab"
            aria-controls="nav-home"
            aria-selected="true"
          >
            Video Editor
          </button>
          <button
            class="nav-link"
            id="nav-profile-tab"
            data-bs-toggle="tab"
            data-bs-target="#nav-profile"
            type="button"
            role="tab"
            aria-controls="nav-profile"
            aria-selected="false"
          >
            Video Lists
          </button>
      
        </div>
      </nav>
      <div class="tab-content" id="nav-tabContent">
        <div
          class="tab-pane fade show active"
          id="nav-home"
          role="tabpanel"
          aria-labelledby="nav-home-tab"
        >
         <form action="${url}" method="POST" enctype="multipart/form-data">
         <h6>${msg}</h6>
          <div class="row tm-mb-90 tm-gallery">
            <div class="col-xl-6 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
              <h4>title</h4>
              <figure class="effect-ming tm-video-item">
              
              <c:choose>
         
         <c:when test = "${imgCheckinFile == true}">
              <img src="/PC00466_VoDangKhoa_ASM_java4/files/${img}" alt="Image" class="img-fluid" id="output"  />
         </c:when>
         
         
         <c:otherwise>
             <img src="${pageContext.request.contextPath}/asset/img/img-03.jpg" alt="Image" class="img-fluid" id="output"   />
         </c:otherwise>
      </c:choose>
                <figcaption
                  class="d-flex align-items-center justify-content-center"
                >
                  <h2>Upload Poster</h2>
                  
                </figcaption>
                <input type="file" id="uploadFilePoster"  style="display: none;" name="poster" onchange="loadFile(event)"  >
              </figure>
             
            </div>
            <div class="col-xl-6 col-lg-4 col-md-6 col-sm-6 col-12 mb-5 mt-3">
              <form action="${url}" method="POST">
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label"
                    >Youtube ID</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    name="id"
                   value="${videotest.id}"
                   maxlength="11"
                   
                  />
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label"
                    >Video tilte</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputPassword1"
                    name="title"
                    value="${videotest.title}"
                  />
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label"
                    >View Count</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputPassword1"
                    value="0"
                    disabled
                    name="views"
                    value="${videotest.views}"
                  />
                </div>
                <div class="d-flex align-items-center">
                  <div class="form-check" style="margin-right: 1.5rem">
                    <input
                      class="form-check-input"
                      type="radio"
                      id="flexRadioDefault1"
                      name="active"
                      value="true"
                      ${videotest.active?'checked':''}
                    />
                    <label class="form-check-label" for="flexRadioDefault1">
                      Active
                    </label>
                  </div>
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="radio"
                      id="flexRadioDefault2"
                      name="active"
                      value="false"
                      ${videotest.active?'':'checked'}
                    />
                    <label class="form-check-label" for="flexRadioDefault2">
                      Unactive
                    </label>
                  </div>
                </div>
            
             
            </div>
           <div class="form-floating">
              <textarea
                class="form-control"
                placeholder="Description"
                id="floatingTextarea"
                name="description"
              >${videotest.description}</textarea>
              <br />
              <div class="d-flex align-items-center flex-row-reverse">
                <div class="button1">
                  <button type="submit" class="btn btn-dark" formaction="${url}/videoAdminCreate">Create</button>
                <button type="submit" class="btn btn-dark" formaction="${url}/videoAdminUpdate">Update</button>
                <button type="submit" class="btn btn-dark" formaction="${url}/videoAdminDelete">Delete</button>
                <button type="button" class="btn btn-dark">Reset</button>
                </div>
              </div>
            </div>
          </div>
           </form>
        </div>
        <div
          class="tab-pane fade"
          id="nav-profile"
          role="tabpanel"
          aria-labelledby="nav-profile-tab"
        >
        <div class="table-responsive-xxl">
            <table class="table">
                <thead>
                    <tr>
                      <th scope="col">Youtube ID</th>
                      <th scope="col">Video Title</th>
                      <th scope="col">Poster</th>
                      <th scope="col">View Count</th>
                      <th scope="col">Description</th>
                      <th scope="col">Status</th>
                      <th scope="col">Action</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="item" items="${videoTest}">
				<tr>
					<th scope="row">${item.id }</th>
					<td>${item.title}</td>
					<td>${item.poster}</td>
					<td>${item.views}</td>
					<td>${item.description}</td>
					<td>${item.active ? "Active":"Unactive"}</td>
					<td><a href="${url}/edit/${item.id}">Edit</a></td>
				</tr>
			</c:forEach>
                  </tbody>
            </table>
            <div class="d-flex align-items-center flex-row-reverse">
                <div class="button1">
                    <button type="button" class="btn btn-dark"> |< </button>
                <button type="button" class="btn btn-dark"> << </button>
                <button type="button" class="btn btn-dark"> >> </button>
                <button type="button" class="btn btn-dark">>|</button>
                </div>
              </div>
              <br>
          </div>
        </div>
      
      </div>
    </div>
  <jsp:include page="/WEB-INF/component/footer.jsp"></jsp:include>

    <script src="${pageContext.request.contextPath}/asset/js/plugins.js"></script>
    <script>
      $(window).on("load", function () {
        $("body").addClass("loaded");
      });
    </script>
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
      integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
      integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
      crossorigin="anonymous"
    ></script>
    <script>
    $("figcaption").click(function() {
        $("input[id='uploadFilePoster']").focus().click();
      });

    var loadFile = function(event) {
        var reader = new FileReader();
        reader.onload = function(){
          var output = document.getElementById('output');
          output.src = reader.result;
        };
        reader.readAsDataURL(event.target.files[0]);
      };
    
    </script>
   
  </body>
</html>