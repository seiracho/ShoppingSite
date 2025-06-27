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
 * Servlet implementation class AdminUserEditServlet
 */
@WebServlet(urlPatterns = {"/adminusereditservlet"})
public class AdminUserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//編集を確定・実行
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//	入力されたデータで DB を更新
		try {
			UserBean userBean=new UserBean();
			userBean.setMember_id(Integer.parseInt(request.getParameter("member_id")));
			userBean.setLast_name(request.getParameter("last_name"));
			userBean.setFirst_name(request.getParameter("first_name"));
			userBean.setAddress(request.getParameter("address"));
			userBean.setMail_address(request.getParameter("mail_address"));
			userBean.setPassword(request.getParameter("password"));
			
			UserDao userDao=new UserDao();
			boolean result=userDao.updateUser(userBean);
			if (result) {
				request.setAttribute("user", userBean);
				response.sendRedirect(request.getContextPath() + "/adminuserservlet");
			} else {
				response.sendRedirect(request.getContextPath() + "/views/editError.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/views/editError.jsp");
		}
		
		
		
	}

}
