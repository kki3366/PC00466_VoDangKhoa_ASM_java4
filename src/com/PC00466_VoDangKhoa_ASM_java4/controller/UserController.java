package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;

@WebServlet({"/Users","/editProfile","/FavoriteList","/ChangePassword","/logoutUser"})
public class UserController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if(uri.contains("Users")) {
			this.doUser(req,resp);
		}
		if(uri.contains("editProfile")) {
			this.doEditProfile(req,resp);
		}
		if(uri.contains("logoutUser")) {
			this.doLogoutUser(req,resp);
		}
		if(uri.contains("FavoriteList")) {
			this.doFavoriteList(req,resp);
		}
		if(uri.contains("ChangePassword")) {
			this.doChangePassword(req,resp);
		}
	}

	private void doChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users != null && users.getRole() == true) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage2.jsp").include(req, resp);
			return;
		}else {
			req.getRequestDispatcher("/WEB-INF/component/changepassword-user.jsp").include(req, resp);
		}
	}

	private void doFavoriteList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users != null && users.getRole() == true) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage2.jsp").include(req, resp);
			return;
		}else {
			req.getRequestDispatcher("/WEB-INF/component/favorite-list-user.jsp").include(req, resp);
		}
		
	}

	private void doLogoutUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}else if(users != null && users.getRole() == true) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}else {
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
	}

	private void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Users users = (Users) req.getSession().getAttribute("user");
		if(users != null && users.getRole() == true) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage2.jsp").include(req, resp);
			return;
		}else {
			
			req.getRequestDispatcher("/WEB-INF/component/user-edit.jsp").include(req, resp);
		}
		
	}

	private void doUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}else if(users != null && users.getRole() == true) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage2.jsp").forward(req, resp);
			return;
		}
		
		resp.sendRedirect(req.getContextPath() + "/home");
		return;
	}
	
}
