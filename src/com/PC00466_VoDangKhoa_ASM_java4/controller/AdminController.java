package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.UserDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;

@WebServlet({"/admin","/admin/user"})
public class AdminController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		if(uri.contains("admin")) {
			this.doAdmin(req,resp);
		}else if(uri.contains("user")) {
			this.doUser(req,resp);
		}
	}

	

	private void doUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		UserDAO userDAO = new UserDAO();
		
		req.setAttribute("items", userDAO.findAll());
		
		req.getRequestDispatcher("/WEB-INF/component/user-admin.jsp").forward(req, resp);
	}



	private void doAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}else if(users != null && users.getRole() == false) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage.jsp").forward(req, resp);
			return;
		}
		resp.sendRedirect(req.getContextPath() + "/home");
	}

}
