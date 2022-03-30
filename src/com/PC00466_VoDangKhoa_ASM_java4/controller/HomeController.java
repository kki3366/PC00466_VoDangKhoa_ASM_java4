package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.UserDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;


@WebServlet({"/home","/login","/register"})
public class HomeController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("home")) {
			req.setAttribute("view", "/WEB-INF/component/videoBody.jsp");
		}else if(uri.contains("login")) {
			this.doSignIn(req,resp);
			req.setAttribute("view", "/WEB-INF/component/login.jsp");
		}else if(uri.contains("register")) {
			req.setAttribute("view", "/WEB-INF/component/register.jsp");
		}
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) {
		
		String method = req.getMethod();
		
		if(method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("username");
			String pw = req.getParameter("password");
			
			try {
				UserDAO dao = new UserDAO();
				Users user = dao.findById(id);
				System.out.println("okay");
		}catch (Exception e) {
			req.setAttribute("msg", "Sai tên đăng nhập");
		}
	}

}
}
