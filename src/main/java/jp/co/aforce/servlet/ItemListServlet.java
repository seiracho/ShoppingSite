package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDao;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet(urlPatterns = {"/itemlistservlet"})
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ItemDao itemDao =new ItemDao();
			List<ItemBean> itemList=itemDao.getAllItems();
			request.setAttribute("items", itemList);
			request.getRequestDispatcher("/views/itemList.jsp").forward(request, response);
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品一覧の取得に失敗しました");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	        doGet(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "商品一覧の表示に失敗しました。");
	        request.getRequestDispatcher("/views/itemList.jsp").forward(request, response);
	    }
	}

}
