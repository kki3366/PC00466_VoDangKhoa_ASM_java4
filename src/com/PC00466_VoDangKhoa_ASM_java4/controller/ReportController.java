package com.PC00466_VoDangKhoa_ASM_java4.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PC00466_VoDangKhoa_ASM_java4.DAO.VideoDAO;
import com.PC00466_VoDangKhoa_ASM_java4.entity.FavoriteUser;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Favorites;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Report;
import com.PC00466_VoDangKhoa_ASM_java4.entity.ShareUser;
import com.PC00466_VoDangKhoa_ASM_java4.entity.Users;
import com.PC00466_VoDangKhoa_ASM_java4.helper.JpaHelper;



@WebServlet({"/Report"})
public class ReportController extends HttpServlet{
	VideoDAO videoDAO = new VideoDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("Report")) {
			this.doReport(req,resp);
		}
	}
	
	private void doFavoritesUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
		EntityManager em  = emf.createEntityManager();
		
			
	}

	private void doReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = (Users) req.getSession().getAttribute("user");
		if(users == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}else if(users != null && users.getRole() == false) {
			req.getRequestDispatcher("/WEB-INF/component/AccessPage.jsp").forward(req, resp);
			return;
		}
		EntityManager entityManager = JpaHelper.getEntityManager();
		String method = req.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			req.setAttribute("forwardToOldValue", req.getParameter("test"));
			String videoId = req.getParameter("test");
			String jpql = "SELECT new " + FavoriteUser.class.getName() +"(n.user.id,n.user.email,n.user.fullname, MAX(n.likeDate))"
					+ " FROM Favorites as n" + " WHERE n.video.title like:vid"
					+ " GROUP BY n.user.id,n.user.email,n.user.fullname";
			TypedQuery<FavoriteUser> query = entityManager.createQuery(jpql, FavoriteUser.class);
			query.setParameter("vid", "%"+videoId+"%");
			List<FavoriteUser> list = query.getResultList();
			req.setAttribute("personWasLike", list);
			
			
			String jpql1 = "SELECT new " + ShareUser.class.getName() +"(n.user_share.fullname,n.emailshare, MAX(n.shareDate))"
					+ " FROM Shares as n" + " WHERE n.video_share.title like:vid1"
					+ " GROUP BY n.user_share.fullname,n.emailshare";
			TypedQuery<ShareUser> query1 = entityManager.createQuery(jpql1, ShareUser.class);
			query1.setParameter("vid1", "%"+videoId+"%");
			List<ShareUser> list1 = query1.getResultList();
			req.setAttribute("personWasShare", list1);
			
		}
		String jpql = "SELECT new " + Report.class.getName() +"(n.video.title, COUNT(n), MAX(n.likeDate), MIN(n.likeDate))"
				+ " FROM Favorites as n"
				+ " GROUP BY n.video.title";
		TypedQuery<Report> query = entityManager.createQuery(jpql, Report.class);
		List<Report> list = query.getResultList();
		req.setAttribute("reports", list);
		req.setAttribute("loadVideoinSelectBox", videoDAO.findTitle());
		req.getRequestDispatcher("/WEB-INF/component/report-admin.jsp").include(req, resp);
	}

	
}
