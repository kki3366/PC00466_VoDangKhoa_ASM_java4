package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

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
			req.setAttribute("view", "/WEB-INF/component/login.jsp");
			this.doSignIn(req,resp);
		}else if(uri.contains("register")) {
			req.setAttribute("view", "/WEB-INF/component/register.jsp");
			this.doRegister(req,resp);
		}
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").include(req, resp);
	}

	
	// chưa bắt lỗi
	private void doRegister(HttpServletRequest req, HttpServletResponse resp) {
		String method = req.getMethod();
		if (method.equalsIgnoreCase("POST")) {
			String password = req.getParameter("password");
			String confirmPassword = req.getParameter("confirmPassword");
			if(confirmPassword.equals(password)) {
				try {
					UserDAO dao = new UserDAO();
					Users user = new Users();
					BeanUtils.populate(user, req.getParameterMap());
					dao.create(user);
					req.setAttribute("msg", "Đăng kí thành công");
					resp.sendRedirect(req.getContextPath() + "/login");
					return;
				} catch (Exception e) {
					req.setAttribute("msg", "Lỗi Đăng kí");
					e.printStackTrace();
				}

			}else {
				req.setAttribute("msg", "Mật khẩu không khớp với xác nhận");
			}
		}
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String method = req.getMethod();
		
		if(method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("username");
			String pw = req.getParameter("password");
			
			try {
				UserDAO dao = new UserDAO();
				Users user = dao.findById(id);
				if (!user.getPassword().equals(pw)) {
					req.setAttribute("msg", "sai mật khẩu");
				} else {
					req.setAttribute("msg", "Đăng nhập thành công");
					req.getSession().setAttribute("user", user);
						resp.sendRedirect(req.getContextPath() + "/home");
						return;
				}
		}catch (Exception e) {
			req.setAttribute("msg", "Sai tên đăng nhập <a href=''>Quên mật khẩu</a>");
			e.printStackTrace();
		}
	}

}
}
