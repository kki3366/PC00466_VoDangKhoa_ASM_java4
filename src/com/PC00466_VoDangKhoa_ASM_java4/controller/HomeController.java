package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.UserDAO;
import com.PC00466_VoDangKhoa_ASM_java4.DAO.VideoDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Videos;




@WebServlet({"/home","/login","/register"})
public class HomeController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		if(uri.contains("home")) {
			
			VideoDAO videoDAO = new VideoDAO();
			String uploadPath = req.getServletContext().getRealPath("/files");
			File dir = new File(uploadPath);
			String urlGet = dir.getAbsolutePath();
			req.setAttribute("video", videoDAO.findAllActive());
			req.setAttribute("poster", urlGet);
			System.out.println(urlGet);
			req.setAttribute("view", "/WEB-INF/component/videoBody.jsp");
		}else if(uri.contains("login")) {
			if(req.getSession().getAttribute("user") != null) {
				resp.sendRedirect(req.getContextPath() + "/home");
				return;
			}else {
				req.setAttribute("view", "/WEB-INF/component/login.jsp");
				this.doSignIn(req,resp);
			}
		}else if(uri.contains("register")) {
			req.setAttribute("view", "/WEB-INF/component/register.jsp");
			this.doRegister(req,resp);
		}
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").include(req, resp);
	}



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
					req.setAttribute("msg", "????ng k?? th??nh c??ng");
					resp.sendRedirect(req.getContextPath() + "/login");
					return;
				} catch (Exception e) {
					req.setAttribute("msg", "L???i ????ng k??");
					e.printStackTrace();
				}

			}else {
				req.setAttribute("msg", "M???t kh???u kh??ng kh???p v???i x??c nh???n");
			}
		}
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String method = req.getMethod();
		
		if(method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("username");
			String pw = req.getParameter("password");
			
			boolean flag = false;
			try {
				UserDAO dao = new UserDAO();
				Users user = dao.findById(id);
				if (!user.getPassword().equals(pw)) {
					req.setAttribute("msg", "Sai m???t kh???u");
					req.setAttribute("passwordValition", "border: 2px solid rgb(188 1 1 / 25%)");
					flag = true;
					req.setAttribute("flag", flag);
				} else {
					req.setAttribute("msg", "????ng nh???p th??nh c??ng");
					req.getSession().setAttribute("user", user);
					
					Users users = (Users) req.getSession().getAttribute("user");
					if(users.getRole() == true) {
						resp.sendRedirect(req.getContextPath() + "/admin");
						return;
					}
					if(user.getRole() == false) {
						resp.sendRedirect(req.getContextPath() + "/Users");
						return;
					}
						
				}
		}catch (Exception e) {
			req.setAttribute("msg", "Sai t??n ????ng nh???p");
			flag = true;
			req.setAttribute("flag", flag);
			req.setAttribute("usernameValition", "border: 2px solid rgb(188 1 1 / 25%)");
			e.printStackTrace();
		}
			
			
			
			
	}

}
	
}
