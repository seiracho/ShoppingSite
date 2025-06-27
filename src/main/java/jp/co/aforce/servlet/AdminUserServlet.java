package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDao;

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet(urlPatterns = {"/adminuserservlet"})
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();
			List<UserBean> userList = dao.getAllUsers();

			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/views/admin-member.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/views/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao userDao=new UserDao();
			List<UserBean>userList=userDao.getAllUsers();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/views/admin-member.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("会員情報の取得に失敗しました");
		}
	}

}
