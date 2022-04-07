package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.UserDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;

@WebServlet({"/admin","/userManager","/userManager/edit/*","/userManager/update","/userManager/delete"})
public class AdminController extends HttpServlet{
	UserDAO userDAO = new UserDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("admin")) {
			this.doAdmin(req,resp);
		}else if(uri.contains("userManager")) {
			if(uri.contains("update")) {
				this.doUpdate(req,resp);
			
			}
			if(uri.contains("edit")) {
				this.doEdit(req,resp);
			}
			if(uri.contains("delete")) {
				this.doDeleteUser(req,resp);
			}
//			
			
			this.doUser(req,resp);
		}
		
	}

	
	boolean flag;
	private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		UserDAO userDAO = new UserDAO();
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
//		System.out.println(id);
		user =userDAO.findById(id);
		flag = false;
	}
	Users user = new Users();

	
private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
	String id = req.getParameter("id");
	Users users = (Users) req.getSession().getAttribute("user");
	System.out.println("session user" + users.getId());
	System.out.println("id của param" + id);
	if(userDAO.findById(id) != null) {
		if(users.getId().equals(id)) {
			req.setAttribute("msg", "không được update user hiện đang đăng nhập");
		}else {
			try {
				BeanUtils.populate(user, req.getParameterMap());
				userDAO.update(user);
				req.setAttribute("msg", "Update thành công");
			} catch (Exception e) {
				req.setAttribute("msg", "Update không thành công");
				
			}
			flag = true;
		}
	}
	
		
	}

	private void doUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(flag == true) {
			req.removeAttribute("test");
		}else {
			req.setAttribute("test", user);
		}
		req.setAttribute("items", userDAO.findAll());
		req.getRequestDispatcher("/WEB-INF/component/user-admin.jsp").include(req, resp);
	}

	

	private void doDeleteUser(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String id = req.getParameter("id");
			userDAO.remove(id);
			req.setAttribute("msg", "Delete thành công");
		} catch (Exception e) {
			req.setAttribute("msg", "Delete thất bại");
			e.printStackTrace();
		}
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
