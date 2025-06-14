package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
//アクセスURL
//urlPatterns:Servletのアクセス用URL(Webブラウザから呼び出すパス)
//どんなＵＲＬでアクセスできるか
//「views(JSPのフォルダ名)」：URLの一部として使われているだけで動作はServlet
@WebServlet(urlPatterns = { "/views/loginservlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストに含まれる文字コードの処理
		request.setCharacterEncoding("UTF-8");
		//出力ストリーム(ブラウザに文字で返すための)
		PrintWriter out = response.getWriter();
		//formから送られてきた値の取得
		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");
		//LoginDaoクラスのインスタンス(オブジェクト作成)
		LoginDao loginDao = new LoginDao();

		try {
			//			〇一致するユーザーがいるか確認
			//			formから送信された値を使う
			//			LoginDaoのsearchメソッド呼び出し
			//			DBから一致するユーザー検索
			//			結果をUserBeanオブジェクトloginSetとして受け取る
			//			☆loginDaoがメソッド行いloginSetが返ってきた(return)後
			UserBean loginSet = loginDao.search(member_id, password);
			//ユーザーが存在すれば(値が一致すれば)
			if (loginSet != null) {
				String fullNameString=loginSet.getLast_name()+loginSet.getFirst_name();
				//sessionに保存
				//ログイン成功時に初めてセッションが作られる
				//既にセッションがある→そのセッションを返す
				HttpSession session = request.getSession(); 
				//有効期限：30分（秒単位）
				session.setMaxInactiveInterval(60*30);
				//BeanオブジェクトをSessionに保存して他ページから取り出せるように
				session.setAttribute("fullNameString", fullNameString);
				//session属性userにログインしたユーザー情報(UserBean)を保存
				session.setAttribute("user", loginSet);
				
				if (session==null || session.getAttribute("user")==null) {
					response.sendRedirect("sessionError.jsp");
					return;
				}
				
				//ログイン画面へforward
				request.getRequestDispatcher("user-menu.jsp").forward(request, response);
			} else {
				//エラー画面へforward
				request.getRequestDispatcher("login-error.jsp").forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(out);
		}

	}

}
