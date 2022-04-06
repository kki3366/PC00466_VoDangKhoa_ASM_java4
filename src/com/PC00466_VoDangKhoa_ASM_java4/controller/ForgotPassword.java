package com.PC00466_VoDangKhoa_ASM_java4.controller;


import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.UserDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;
import com.PC00466_VoDangKhoa_ASM_java4.helper.SendEmailHelper;


@WebServlet({"/rememberPassword","/verifyCode","/setNewPassword","/Back"})
public class ForgotPassword extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("rememberPassword")) {
			this.doRememberPassword(req,resp);
		}else if(uri.contains("verifyCode")) {
			this.doVerifyCode(req,resp);
		}else if(uri.contains("setNewPassword")) {
			this.doSetNewPassword(req,resp);
		}else if(uri.contains("Back")) {
			this.doBack(req,resp);
		}
	}
	
	
	private void doBack(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("userEmail")!=null) {
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/rememberPassword");
			return;
		}
		
		resp.sendRedirect(req.getContextPath() + "/home");
	}


	private void doSetNewPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("userEmail") == null) {
			resp.sendRedirect(req.getContextPath() + "/home");
			return;
		}else {
			String method = req.getMethod();
			if(method.equalsIgnoreCase("POST")) {
				String newPassword = req.getParameter("nPws");
				String confirmPassword = req.getParameter("CnPwd");
				if(newPassword.equals(confirmPassword)) {
					UserDAO userDAO = new UserDAO();
					Users user = userDAO.findByEmail(req.getSession().getAttribute("userEmail").toString());
					user.setPassword(confirmPassword);
					userDAO.update(user);
					req.setAttribute("msg", "Đổi thành công");
					req.getSession().invalidate();
					resp.sendRedirect(req.getContextPath() +"/login");
					return;
				}else {
					req.setAttribute("msg", "Xác nhận mật khẩu không đúng");
				}
			}
		}

		
		req.getRequestDispatcher("/WEB-INF/component/setNewPassword.jsp").forward(req, resp);
	}

	Random random = new Random();
	public int rdCode = random.nextInt(999999);
	
	private void doVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		if(req.getSession().getAttribute("userEmail") == null) {
			resp.sendRedirect(req.getContextPath() + "/home");
			return;
		}else {
			String method = req.getMethod();
			if(method.equalsIgnoreCase("POST")) {
				String getCode = req.getParameter("code");
				
				if(Integer.parseInt(getCode) == rdCode) {
					resp.sendRedirect(req.getContextPath() + "/setNewPassword");
					return;
				}
				
			}	
			
		}

		
		req.getRequestDispatcher("/WEB-INF/component/verifyCode.jsp").forward(req, resp);
	}

	private void doRememberPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String method = req.getMethod();
		
		if(method.equalsIgnoreCase("POST")) {
			String username = req.getParameter("username");
			try {
				UserDAO userDAO = new UserDAO();
				Users user = userDAO.findById(username);
				if(!user.getId().equals(username)) {
					req.setAttribute("msg", "Không tìm thấy tên đăng nhập");
				}else {
					SendEmailHelper helper = new SendEmailHelper();
					helper.SendcodeEmail(user.getEmail(),rdCode); // vào temp-mail.org
					req.getSession().setAttribute("userEmail", user.getEmail());
					resp.sendRedirect(req.getContextPath() + "/verifyCode");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		req.getRequestDispatcher("/WEB-INF/component/rememberPassword.jsp").forward(req, resp);
	}
	

	
}
