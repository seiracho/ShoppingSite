package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.BrandBean;
import jp.co.aforce.dao.BrandDao;

/**
 * Servlet implementation class BrandListServlet
 */
@WebServlet(urlPatterns = {"/brandlistservlet"})
public class BrandListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			BrandDao brandDao=new BrandDao();
			List<BrandBean> brandList =brandDao.getAllBrands();
			request.setAttribute("brands", brandList);
			request.getRequestDispatcher("/views/brandList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ブランド一覧の取得に失敗しました");
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
