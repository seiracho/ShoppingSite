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
 * Servlet implementation class AdminItemDeleteServlet
 */
@WebServlet(urlPatterns = {"/adminitemdeleteservlet"})
public class AdminItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		ItemBean itemBean=new ItemBean();
		itemBean.setItem_id(Integer.parseInt(request.getParameter("item_id")));
		
		
		try {
			//DAO削除処理呼び出し
			ItemDao itemDao=new ItemDao();
			itemDao.deleteItem(itemBean);
			request.getRequestDispatcher("adminitemlistservlet").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "削除失敗");
			request.getRequestDispatcher("/views/admin-item.jsp");
		}
		
	}

}
