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
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet(urlPatterns = {"/updatecartservlet"})
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		Map<Integer, Integer>cartMap=(Map<Integer,Integer>)session.getAttribute("cart");
		if (cartMap==null) {
			cartMap=new HashMap<>();
		}
		
		String action=request.getParameter("action");
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		
		if ("update".equals(action)) {
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			if (quantity > 0) {
				cartMap.put(itemId, quantity);
			}
		}else if ("delete".equals(action)) {
			cartMap.remove(itemId);
		}
		session.setAttribute("cart", cartMap);
		response.sendRedirect(request.getContextPath()+"/views/cart.jsp");
		}
	}

