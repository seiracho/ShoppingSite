package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDao;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet(urlPatterns = {"/itemdetailservlet"})
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String itemIdParam= request.getParameter("item_id");
			if (itemIdParam == null || itemIdParam.isEmpty()) {
				response.sendRedirect("itemlistservlet");
				return;
			}
			
			int item_id=Integer.parseInt(itemIdParam);
			ItemDao itemDao=new ItemDao();
			ItemBean itemBean=itemDao.getItemById(item_id);
			
			if (itemBean != null) {
				request.setAttribute("itemBean", itemBean);
				request.getRequestDispatcher("/views/itemDetail.jsp").forward(request, response);
			} else {
				response.sendRedirect("itemlistservlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("itemlistservlet");
		}
		
	}
	

}
