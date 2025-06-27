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
 * Servlet implementation class AdminItemEditServlet
 */
@WebServlet(urlPatterns = {"/adminitemeditservlet"})
public class AdminItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		ItemBean itemBean=new ItemBean();
		itemBean.setName(request.getParameter("name"));
		itemBean.setPrice(Integer.parseInt(request.getParameter("price")));
		itemBean.setBrand_id(Integer.parseInt(request.getParameter("brand_id")));
		itemBean.setStock(Integer.parseInt(request.getParameter("stock")));
		itemBean.setSdgs_category(request.getParameter("sdgs_category"));
		itemBean.setDescription(request.getParameter("description"));
		itemBean.setImage_url(request.getParameter("image_url"));
		itemBean.setSub_image1(request.getParameter("sub_image1"));
		itemBean.setSub_image2(request.getParameter("sub_image2"));
		itemBean.setSub_image3(request.getParameter("sub_image3"));
		itemBean.setSub_image4(request.getParameter("sub_image4"));
		itemBean.setItem_id(Integer.parseInt(request.getParameter("item_id")));
		
		ItemDao itemDao=new ItemDao();
		try {
			itemDao.updateItem(itemBean);
			request.getRequestDispatcher("adminitemlistservlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "更新失敗");
			request.getRequestDispatcher("/views/admin-item.jsp").forward(request, response);;
		}
		
	}

}
