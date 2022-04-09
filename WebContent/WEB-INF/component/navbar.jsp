<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
                <i class="fas fa-film mr-2"></i>
                Catalog-Z
            </a>
            <c:choose>
         
         <c:when test = "${sessionScope.user != null && sessionScope.user.role == true}">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
             <li class="nav-item">
                    <a class="nav-link nav-link-1 active" aria-current="page" href="${pageContext.request.contextPath}/admin">Welcome ${ sessionScope.user.fullname}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-1" aria-current="page" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-2" href="${pageContext.request.contextPath}/videoAdmin">Videos Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-3" href="${pageContext.request.contextPath}/userManager">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-4" href="contact.html">Contact</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link nav-link-4" href="${pageContext.request.contextPath}/logoutAdmin">Logout</a>
                </li>
               
            </ul>
            </div>
         </c:when>
         
         <c:otherwise>
             <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
                <button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/login'">Login</button>
            </ul>
            </div>
         </c:otherwise>
      </c:choose>
        </div>
    </nav>