package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.VideoDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Videos;

@MultipartConfig
@WebServlet({"/videoAdmin","/videoAdmin/videoAdminCreate","/videoAdmin/edit/*","/videoAdmin/videoAdminDelete","/videoAdmin/videoAdminUpdate"})
public class VideoController extends HttpServlet{
	VideoDAO videoDAO = new VideoDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("videoAdmin")) {
			
			if(uri.contains("edit")) {
				this.doEdit(req,resp);
			}
			if(uri.contains("videoAdminCreate")) {
				this.dovideoAdminCreate(req,resp);
			}
			if(uri.contains("videoAdminDelete")) {
				this.dovideoAdminDelete(req,resp);
			}
			if(uri.contains("videoAdminUpdate")) {
				this.dovideoAdminUpdate(req,resp);
			}
			this.dovideoAdmin(req,resp);
		}
		
		
	}
	
	private void dovideoAdminUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users != null && users.getRole() == false) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage.jsp").include(req, resp);
//			resp.sendRedirect(req.getContextPath() +"/home");
			return;
		}else {
			try {
				Videos videos = new Videos();
				String id = req.getParameter("id");
				videos = videoDAO.findById(id);
				String uploadPath = req.getServletContext().getRealPath("/files");
				File dir = new File(uploadPath);
				String urlGet = dir.getAbsolutePath() + "\\" + videos.getPoster();
				File check = new File(urlGet);
				if(check.exists() == true) {
					String filename1 = String.valueOf(check);
					filename1=  filename1.substring(filename1.lastIndexOf("\\")+1);
					System.out.println("File tồn tại " + "" + check);
					Part photo = req.getPart("poster");
					File photoFile = new File(dir, photo.getSubmittedFileName());
//					System.out.println("file đã muốn sửa " + photo.getSubmittedFileName().toString());
					if(filename1.equals(videos.getPoster())) {

						BeanUtils.populate(videos, req.getParameterMap());
						videos.setPoster(filename1);
						videoDAO.update(videos);
						req.setAttribute("msg", "Update thành công");
					}
					
					
				}else {
					Part photo = req.getPart("poster");
					File photoFile = new File(dir, photo.getSubmittedFileName());
					photo.write(photoFile.getAbsolutePath());
					String filename = String.valueOf(photoFile);
					filename=  filename.substring(filename.lastIndexOf("\\")+1);
					System.out.println("ảnh đã sub string là : " + filename);
					BeanUtils.populate(videos, req.getParameterMap());
					videos.setPoster(filename);
					videoDAO.update(videos);
					req.setAttribute("msg", "Update thành công");
				}
				Part photo = req.getPart("poster");
				File photoFile = new File(dir, photo.getSubmittedFileName());
				photo.write(photoFile.getAbsolutePath());
				String filename = String.valueOf(photoFile);
				filename=  filename.substring(filename.lastIndexOf("\\")+1);
				System.out.println("ảnh đã sub string là : " + filename);
				BeanUtils.populate(videos, req.getParameterMap());
				videos.setPoster(filename);
				videoDAO.update(videos);
				req.setAttribute("msg", "Update thành công");
			} catch (Exception e) {
				req.setAttribute("msg", "Update thất bại");
				e.printStackTrace();
			}
		}
		flag = true;
	}

	boolean flag;
	
	private void dovideoAdminDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users != null && users.getRole() == false) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage.jsp").include(req, resp);
//			resp.sendRedirect(req.getContextPath() +"/home");
			return;
		}else {
			try {
				
				String id = req.getParameter("id");
				videos = videoDAO.findById(id);
				String uploadPath = req.getServletContext().getRealPath("/files");
				File dir = new File(uploadPath);
				String urlGet = dir.getAbsolutePath() + "\\" + videos.getPoster();
				File check = new File(urlGet);
				if(check.exists() == true) {
					check.deleteOnExit();
					if(check.getAbsoluteFile().delete() == true) {
						System.out.println("file đã xóa");
					}else {
						System.out.println("file chưa xóa");
					}
					videoDAO.remove(id);
					req.setAttribute("msg", "Delete thành công");
					resp.sendRedirect(req.getContextPath() + "/videoAdmin");
					System.out.println("ảnh đang tồn tại");
				}else {
					videoDAO.remove(id);
					req.setAttribute("msg", "Delete thành công");
					resp.sendRedirect(req.getContextPath() + "/videoAdmin");
					System.out.println("ảnh ko tồn tại");
				}
				flag= true;
			} catch (Exception e) {
				req.setAttribute("msg", "Delete thất bại");
				e.printStackTrace();
			}
		}
		
	}

	private void dovideoAdminCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users != null && users.getRole() == false) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage.jsp").include(req, resp);
//			resp.sendRedirect(req.getContextPath() +"/home");
			return;
		}else {
			Videos videos = new Videos();
			String id = req.getParameter("id");
			if(videoDAO.findById(id) != null) {
				req.setAttribute("msg", "Video đã được tồn tại");
				System.out.println("video đã được thêm");
			}else {
				try {
					String uploadPath = req.getServletContext().getRealPath("/files");
					File dir = new File(uploadPath);
					boolean a = false;
					if (!dir.exists()) {
						a = dir.mkdir();
					}
					
					System.out.println(" " + dir);
					Part photo = req.getPart("poster");
					File photoFile = new File(dir, photo.getSubmittedFileName());
					photo.write(photoFile.getAbsolutePath());
					String filename = String.valueOf(photoFile);
					filename=  filename.substring(filename.lastIndexOf("\\")+1);
					System.out.println("ảnh đã sub string là : " + filename);
					BeanUtils.populate(videos, req.getParameterMap());
					videos.setPoster(filename);
					videoDAO.create(videos);
					flag = true;
					req.setAttribute("msg", "Thêm video thành công");
					resp.sendRedirect(req.getContextPath() + "/videoAdmin");
					return;
				} catch (Exception e) {
					req.setAttribute("msg", "Thêm video thất bại. Vui lòng kiểm tra xem các trường đã nhập đủ chưa");
					e.printStackTrace();
				
				}
				
			}
		}
		
		
		
		
	}
	Videos videos = new Videos();
	private void doEdit(HttpServletRequest req, HttpServletResponse resp) {
		
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		videos = videoDAO.findById(id);
		String uploadPath = req.getServletContext().getRealPath("/files");
		File dir = new File(uploadPath);
//		System.out.println("link photo là: "+ dir.getAbsolutePath());
//		String urlGet = dir.getAbsolutePath() + "//" + videos.getPoster();
//		System.out.println("posters đã get là: " +urlGet);
//		File check = new File(urlGet);
//		System.out.println(check.exists()?"Tồn tại":"không tồn tại");
		String urlGet = dir.getAbsolutePath() + "//" + videos.getPoster();
		File check = new File(urlGet);
		req.setAttribute("imgCheckinFile", check.exists());
		req.setAttribute("img", videos.getPoster());
		flag = false;
	}


	private void dovideoAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users == null) {
		
			req.getRequestDispatcher("/WEB-INF/component/AccessPage1.jsp").include(req, resp);
			return;
		}else if(users != null && users.getRole() == false) {
			
			req.getRequestDispatcher("/WEB-INF/component/AccessPage.jsp").include(req, resp);
			return;
		}else {
			if(flag == true) {
				req.removeAttribute("videotest");
			}else {
				req.setAttribute("videotest", videos);
			}
		
		}
		
		req.setAttribute("videoTest", videoDAO.findAll());
		req.getRequestDispatcher("/WEB-INF/component/video-admin.jsp").include(req, resp);
	}

	
}
