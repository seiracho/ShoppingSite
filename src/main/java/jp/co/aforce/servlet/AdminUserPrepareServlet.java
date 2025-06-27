package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDao;

/**
 * Servlet implementation class AdminUserPrepareServlet
 */
//編集フォームを表示
@WebServlet(urlPatterns = {"/adminuserprepareservlet"})
public class AdminUserPrepareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	member_id を元にユーザー取得し JSP に渡す
		try {
			int memberId=Integer.parseInt(request.getParameter("member_id"));
			UserDao userDao=new UserDao();
			UserBean userBean=userDao.getUserById(memberId);
			request.setAttribute("userList", userBean);
			request.getRequestDispatcher("/views/admin-edit-member.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/views/editError.jsp");
		}
	}


}
