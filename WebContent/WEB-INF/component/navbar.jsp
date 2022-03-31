<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
                <i class="fas fa-film mr-2"></i>
                Catalog-Z
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
                <!-- <li class="nav-item">
                    <a class="nav-link nav-link-1 active" aria-current="page" href="index.html">Photos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-2" href="videos.html">Videos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-3" href="about.html">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-4" href="contact.html">Contact</a>
                </li> -->
                <button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/login'">Login</button>
            </ul>
            </div>
        </div>
    </nav>