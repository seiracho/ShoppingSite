package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.Login;
import jp.co.aforce.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/views/loginservlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		//DAOからユーザーテーブル情報を取得
		LoginDao loginDao = new LoginDao();
		
		try {
			Login loginSet=loginDao.search(id, password);
			
			//nullじゃないかつemptyじゃなかったら
			if (loginSet != null) {
				//sessionに保存
				HttpSession session=request.getSession();
				session.setAttribute("last_name", loginSet);
				//ログイン画面へforward
				request.getRequestDispatcher("user-menu.jsp").forward(request, response);
			}else {
				//エラー画面へforward
				request.getRequestDispatcher("login-error.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(out);
		}
		
	}

}
