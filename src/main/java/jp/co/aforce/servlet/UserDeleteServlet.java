package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDao;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet(urlPatterns = {"/views/userdeleteservlet"})
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//削除ボタン押したときに送られてくるmemberid取得
		String member_id=request.getParameter("member_id");
		
		try {
			//UserBeanにmemberidセット
			UserBean userBean=new UserBean();
			userBean.setMember_id(member_id);
			//DAO削除処理呼び出し
			UserDao userDao=new UserDao();
			//deleteUserメソッドで行われた削除結果をbooleanのdeletedで受け取る
			boolean deleted=userDao.deleteUser(userBean);
			
			if (deleted) {
				//session削除
				HttpSession session=request.getSession(false);
				if (session !=null) {
					session.invalidate();
				}
				//成功画面にフォワード
				request.getRequestDispatcher("userDeleteSuccess.jsp").forward(request, response);
			}else {
				//失敗画面にフォワード
				request.getRequestDispatcher("deleteError.jsp").forward(request, response);
			}
		//例外エラー用
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("deleteError.jsp").forward(request, response);
		
		
		
		}
		
		
	}

}
