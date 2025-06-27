package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BrandDetailServlet
 */
@WebServlet("/mypageservlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Object loginUserObject=(session !=null) ? session.getAttribute("user"): null;
		//ログイン済み
		if (loginUserObject != null) {
			request.getRequestDispatcher("/views/user-menu.jsp").forward(request, response);
		//未ログイン
		}else {
			//※戻ってくる用にセッションに遷移先保存
			session=request.getSession();
			session.setAttribute("return_to", "mypageservlet");
			response.sendRedirect(request.getContextPath() + "/views/login-in.jsp");
		}
		
	}


}
