package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.UserBean;

//DBにある情報をSQLで検索する専用クラス
//DAOクラス継承
public class LoginDao extends DAO {
	//ログイン情報(Bean)を取得するsearchメソッド
	//見つかったらLoginオブジェクトにして返す
	public UserBean search(String member_id, String password) throws Exception {
		//見つかったユーザー情報を入れるための変数
		//最初は見つかってないからnull
		UserBean loginSet = null;
		//親クラスDAOにあるgetConnection()使ってDBと接続
		Connection connection = getConnection();
		//SQLで命令
		//SELECTの後に取り出したいもの、WHEREの後は条件
		String sql = "SELECT * FROM users WHERE MEMBER_ID=? AND PASSWORD=?";
		//SQLが探した情報を入れる
		PreparedStatement statement = connection.prepareStatement(sql);
		//？の設定(実際の値をセット)
		statement.setString(1, member_id);
		statement.setString(2, password);
		//実際に検索実行し結果をResultSetに入れる
		ResultSet rs = statement.executeQuery();

		//検索結果をBeanの中に入れる
		//データが見つかればLoginオブジェクトに情報を入れて返す
		//結果がある間中身を読み取る
		while (rs.next()) {
			//LoginというBeanに値を入れてく
			loginSet = new UserBean();
			//rs.getString():DBの中身取り出し
			//loginSetに保存
			loginSet.setMember_id(rs.getString("member_id"));
			loginSet.setPassword(rs.getString("password"));
			loginSet.setLast_name(rs.getString("last_name"));
			loginSet.setFirst_name(rs.getString("first_name"));
			loginSet.setAddress(rs.getString("address"));
			loginSet.setMail_address(rs.getString("mail_address"));
		}
		//DBとの接続閉じる
		connection.close();
		statement.close();
		//呼び出し元に結果を返す
		return loginSet;
	}
}
