package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PurchaseCheckServlet
 */
@WebServlet(urlPatterns = {"/purchasecheckservlet"})
public class PurchaseCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Object loginUserObject=(session !=null) ? session.getAttribute("user"):null;
		if (loginUserObject == null) {
			//未ログイン
			//新しいセッションがないときは作成
			session=request.getSession();
			session.setAttribute("return_to", "/views/purchase-in.jsp");
			response.sendRedirect(request.getContextPath()+"/views/login-in.jsp");
		} else {
			//ログイン済み
			response.sendRedirect(request.getContextPath()+"/views/purchase-in.jsp");
		}
		
	}

}
