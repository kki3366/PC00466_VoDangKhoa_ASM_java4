package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.UserDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;

@WebServlet({"/admin","/userManager","/userManager/edit/*"})
public class AdminController extends HttpServlet{
	UserDAO userDAO = new UserDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("admin")) {
			this.doAdmin(req,resp);
		}else if(uri.contains("userManager")) {
			this.doUser(req,resp);
			if(uri.contains("edit")) {
				this.doEdit(req,resp);
			}
		}
	}


	Users user = new Users();
	private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		UserDAO userDAO = new UserDAO();
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		System.out.println(id);
		user =userDAO.findById(id);
		if(user == null) {
			System.out.println("user đang null");
		}else {
			System.out.println("user không null");
		}
		req.setAttribute("test", user);
		
	}



	private void doUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("items", userDAO.findAll());
		req.setAttribute("test", user);
		req.getRequestDispatcher("/WEB-INF/component/user-admin.jsp").forward(req, resp);
		return;
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
		return;
	}

}
