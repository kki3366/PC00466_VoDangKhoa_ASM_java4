<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="container-fluid tm-container-content tm-mt-60">
        <div class="row mb-4">
            <h2 class="col-6 tm-text-primary">
                Latest Photos
            </h2>
            <div class="col-6 d-flex justify-content-end align-items-center">
                <form action="" class="tm-text-primary">
                    Page <input type="text" value="1" size="1" class="tm-input-paging tm-text-primary"> of 200
                </form>
            </div>
        </div>
        <div class="row tm-mb-90 tm-gallery">
        	 <c:forEach items = "${video}"  var = "video">
        <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
                <h4>${video.title}</h4>
                <figure class="effect-ming tm-video-item">
                    <img src="${pageContext.request.contextPath}/files/${video.poster}" alt="Image" class="img-fluid">
                    <figcaption class="d-flex align-items-center justify-content-center">
                        <h2>Clocks</h2>
                        <a href="photo-detail.html">View more</a>
                    </figcaption>                    
                </figure>
                <div class="d-flex flex-wrap justify-content-between tm-text-gray">
                    <button type="button" class="btn btn-primary">Like</button>
                    <button type="button" class="btn btn-warning">Share</button>
                    
                    <span class="tm-text-gray-light mt-2">14 Oct 2020</span>
                    <span class="mt-2">${video.views }</span>
                </div>
            </div>
      </c:forEach>
                 
        </div> <!-- row -->
       
    </div> <!-- container-fluid, tm-container-content -->