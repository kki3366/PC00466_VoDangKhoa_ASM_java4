<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Catalog-Z Contact page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/fontawesome/css/all.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/templatemo-style.css" />
    <!--
    
TemplateMo 556 Catalog-Z

https://templatemo.com/tm-556-catalog-z

-->
  </head>
  <body>
  <c:url var="url" value="" />
    <!-- Page Loader -->
    <div id="loader-wrapper">
      <div id="loader"></div>

      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
    </div>
    <nav class="navbar navbar-expand-lg">
      <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
          <i class="fas fa-film mr-2"></i>
          Catalog-Z
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
            <button type="button" class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/login'">Login</button>
          </ul>
        </div>
      </div>
    </nav>

    <div
      class="tm-hero d-flex justify-content-center align-items-center"
      data-parallax="scroll"
      data-image-src="${pageContext.request.contextPath}/asset/img/hero.jpg"
    ></div>

    <div class="container-fluid tm-mt-60">
      <div class="row tm-mb-50">
        <div class="col-lg-12 col-12 mb-5">
          <h2 class="tm-text-primary mb-5 text-center">Quên mật khẩu</h2>
          <form
            id="contact-form"
            action="${url }"
            method="POST"
            class="tm-contact-form mx-auto"
          >
            <div class="form-group">
              <input
                type="text"
                name="code"
                class="form-control rounded-0"
                placeholder="Verify Code"
                required
                  pattern="[0-9]+"
              />
            </div>

            <div class="form-group tm-text-right">
              <button type="submit" class="btn btn-primary">Send</button>
                <a href="${pageContext.request.contextPath}/Back" style="cursor: pointer;border: 1px solid red;margin: 1.8rem;padding-bottom: 18px;padding-top: 14px;padding-left: 20px;padding-right: 20px;">Back</a>
            </div>
          
          </form>
        </div>
      </div>
    </div>
    <!-- container-fluid, tm-container-content -->

    <footer class="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
      <div class="container-fluid tm-container-small">
        <div class="row">
          <div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
            <h3 class="tm-text-primary mb-4 tm-footer-title">
              About Catalog-Z
            </h3>
            <p>
              Catalog-Z is free Bootstrap 5 Alpha 2 HTML Template for video and
              photo websites. You can freely use this TemplateMo layout for a
              front-end integration with any kind of CMS website.
            </p>
          </div>
          <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
            <h3 class="tm-text-primary mb-4 tm-footer-title">Our Links</h3>
            <ul class="tm-footer-links pl-0">
              <li><a href="#">Advertise</a></li>
              <li><a href="#">Support</a></li>
              <li><a href="#">Our Company</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
          <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
            <ul class="tm-social-links d-flex justify-content-end pl-0 mb-5">
              <li class="mb-2">
                <a href="https://facebook.com"
                  ><i class="fab fa-facebook"></i
                ></a>
              </li>
              <li class="mb-2">
                <a href="https://twitter.com"><i class="fab fa-twitter"></i></a>
              </li>
              <li class="mb-2">
                <a href="https://instagram.com"
                  ><i class="fab fa-instagram"></i
                ></a>
              </li>
              <li class="mb-2">
                <a href="https://pinterest.com"
                  ><i class="fab fa-pinterest"></i
                ></a>
              </li>
            </ul>
            <a href="#" class="tm-text-gray text-right d-block mb-2"
              >Terms of Use</a
            >
            <a href="#" class="tm-text-gray text-right d-block"
              >Privacy Policy</a
            >
          </div>
        </div>
        <div class="row">
          <div class="col-lg-8 col-md-7 col-12 px-5 mb-3">
            Copyright 2020 Catalog-Z Company. All rights reserved.
          </div>
          <div class="col-lg-4 col-md-5 col-12 px-5 text-right">
            Designed by
            <a
              href="https://templatemo.com"
              class="tm-text-gray"
              rel="sponsored"
              target="_parent"
              >TemplateMo</a
            >
          </div>
        </div>
      </div>
    </footer>

    <script src="${pageContext.request.contextPath}/asset/js/plugins.js"></script>
    <script>
      $(window).on("load", function () {
        $("body").addClass("loaded");
      });

    </script>
    <script>
   
    </script>
  </body>
</html>
