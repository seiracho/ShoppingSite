package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDao;

/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet(urlPatterns = {"/views/useraddservlet"})
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//登録処理を受け取る
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		String member_id=request.getParameter("member_id");
		String password=request.getParameter("password");
		String last_name=request.getParameter("last_name");
		String first_name=request.getParameter("first_name");
		String address=request.getParameter("address");
		String mail_address=request.getParameter("mail_address");
		
		UserDao userDao=new UserDao();
		//DBよりメンバー情報があれば既に登録済み
		//なければ新規会員登録
		try {
			//UserDaoのuserCheckメソッドで既にmember_idが登録済みか調べる
			UserBean user=new UserBean();
			user.setMember_id(member_id);
			boolean isDuplicate=userDao.userCheck(user);
			//既にmember_idが登録済み(重複)
			if (isDuplicate) {
				request.getRequestDispatcher("loginError.jsp").forward(request, response);
			}else{
				//ユーザー情報まとめたBeanに取得値セット
				UserBean newUserBean=new UserBean();
				newUserBean.setMember_id(member_id);
				newUserBean.setPassword(password);
				newUserBean.setLast_name(last_name);
				newUserBean.setFirst_name(first_name);
				newUserBean.setAddress(address);
				newUserBean.setMail_address(mail_address);
				
				//UserDaoのaddUserメソッドで登録する
				//真偽値(条件分岐、フラグ、チェック結果)
				boolean result =userDao.addUser(newUserBean);
				//登録成功なら
				if (result) {
					request.setAttribute("newUserBean", newUserBean);
					request.getRequestDispatcher("userAddConfirm.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("userAddError.jsp").forward(request, response);
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(out);
		}
	}

}
