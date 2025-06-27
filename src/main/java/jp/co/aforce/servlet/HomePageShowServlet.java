package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.BrandBean;
import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.BrandDao;
import jp.co.aforce.dao.ItemDao;

/**
 * Servlet implementation class HomePageShowServlet
 */
@WebServlet(urlPatterns = {"/homepageshowservlet"})
public class HomePageShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ItemDao itemDao=new ItemDao();
			List<ItemBean> itemList=itemDao.getAllItems();
			BrandDao brandDao=new BrandDao();
			List<BrandBean> brandList =brandDao.getAllBrands();
			
			request.setAttribute("itemList", itemList);
			request.setAttribute("brandList", brandList);
			request.getRequestDispatcher("/views/home-page.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
