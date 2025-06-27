package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.OrderBean;
import jp.co.aforce.beans.OrderItemBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.ItemDao;
import jp.co.aforce.dao.OrderDao;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet(urlPatterns = {"/purchaseservlet"})
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		UserBean userBean=(session !=null) ? (UserBean)session.getAttribute("user"):null;
		Map<Integer, Integer>cartMap=(Map<Integer, Integer>)session.getAttribute("cart");
		if (userBean == null || cartMap == null || cartMap.isEmpty()) {
			response.sendRedirect(request.getContextPath()+"/views/cart.jsp");
			return;
		}
		
		try {
			OrderDao orderDao=new OrderDao();
			//合計金額計算
			ItemDao itemDao=new ItemDao();
			int totalPrice=0;
			
			for (Map.Entry<Integer, Integer>entry:cartMap.entrySet()) {
				int itemId=entry.getKey();
				int quantity=entry.getValue();
				//実際の商品価格をDBから取得
				ItemBean itemBean=itemDao.getItemById(itemId);
				if (itemBean == null) {
					//商品が見つからなかった場合
					response.sendRedirect(request.getContextPath()+"/views/cart.jsp");
					return;
				}
	
				int price=itemBean.getPrice();
				totalPrice += price * quantity;
			}
			//注文登録
			OrderBean orderBean=new OrderBean();
			orderBean.setMember_id(userBean.getMember_id());
			// 日付を現在日付に（java.time）
			String orderDate=java.time.LocalDate.now().toString();
			orderBean.setOrder_date(orderDate);
			orderBean.setTotal_price(totalPrice);
			// 注文テーブルに登録して注文IDを取得
			int orderId=orderDao.insertOrder(orderBean);
			//明細登録
			for (Map.Entry<Integer, Integer>entry:cartMap.entrySet()) {
				int itemId=entry.getKey();
				int quantity=entry.getValue();
				ItemBean itemBean=itemDao.getItemById(itemId);
				int price =itemBean.getPrice();
			
			OrderItemBean orderItemBean=new OrderItemBean();
			orderItemBean.setOrder_id(orderId);
			orderItemBean.setItem_id(itemId);
			orderItemBean.setQuantity(quantity);
			orderItemBean.setPrice_at_order(price);
			
			orderDao.insertOrderItem(orderItemBean);
			}
			
			session.setAttribute("lastOrderId", orderId);
			request.getRequestDispatcher("/views/purchase-out.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/views/purchase-error-insert.jsp");
		}
	}

}
