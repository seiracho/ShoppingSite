package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(urlPatterns = {"/cartservlet"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//cart中身表示（Get）
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request	.getSession();
		Map<Integer, Integer> cartMap=(Map<Integer, Integer>)session.getAttribute("cart");
		
		request.setAttribute("cart", cartMap);
		request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
	
	}
	
	//cart追加（Post）
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int item_id=Integer.parseInt(request.getParameter("item_id"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session=request.getSession();
		Map<Integer, Integer> cartMap=(Map<Integer, Integer>)session.getAttribute("cart");
		
		if (cartMap == null) {
			cartMap =new HashMap<>();
		}
	
		cartMap.put(item_id, cartMap.getOrDefault(item_id, 0) + quantity);
		session.setAttribute("cart", cartMap);
		//元の商品詳細ページに戻す
		response.sendRedirect(request.getContextPath() + "/itemdetailservlet?item_id=" + item_id);

	}

}
