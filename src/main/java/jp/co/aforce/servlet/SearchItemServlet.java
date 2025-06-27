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
 * Servlet implementation class SearchItemServlet
 */
@WebServlet(urlPatterns = {"/searchitemservlet"})
public class SearchItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		String brand_id=request.getParameter("brand_id");
		String sdgs_category=request.getParameter("sdgs_category");
		String sort=request.getParameter("sort");
		ItemDao itemDao=new ItemDao();
		try {
			List<ItemBean>searchList=itemDao.searchItems(keyword,brand_id,sdgs_category, sort);
			request.setAttribute("items", searchList);
			request.getRequestDispatcher("/views/itemList.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "検索に失敗しました");
			request.getRequestDispatcher("/views/itemList.jsp").forward(request, response);
		}
	}

}
