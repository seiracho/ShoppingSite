package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet(urlPatterns = {"/homepageservlet"})
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		UserBean userBean=(session != null) ? (UserBean)session.getAttribute("user"):null;
		if (userBean != null) {
			request.getRequestDispatcher("/views/home-page.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/views/login-in.jsp");
		}
	}


}
