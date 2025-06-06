package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDao;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet(urlPatterns = {"/views/usereditservlet"})
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String member_id=request.getParameter("member_id");
		String password=request.getParameter("password");
		String last_name=request.getParameter("last_name");
		String first_name=request.getParameter("first_name");
		String address=request.getParameter("address");
		String mail_address=request.getParameter("mail_address");
		
		UserDao userDao=new UserDao();
		
		try {
			
			UserBean user=new UserBean();
			user.setMember_id(member_id);
			user.setPassword(password);
			user.setLast_name(last_name);
			user.setFirst_name(first_name);
			user.setAddress(address);
			user.setMail_address(mail_address);
			
			boolean result=userDao.updateUser(user);
			if (result) {
				//ユーザー情報をセッションに更新
				//request.getSession();既にログイン済みのセッションが存在していればそれを使う
				HttpSession ediHttpSession=request.getSession();
				//ログインしていない又は、セッション切れ
				if (ediHttpSession==null || ediHttpSession.getAttribute("user")==null) {
					response.sendRedirect("sessionError.jsp");
					return;
				}
				
				//ログイン時と同じuser属性に更新後のUserBeanを上書き保存
				ediHttpSession.setAttribute("user", user);
				
				
				
				request.getRequestDispatcher("userEditConfirm.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("editError.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(out);
			request.getRequestDispatcher("editError.jsp").forward(request, response);
		}
		
	}

}
