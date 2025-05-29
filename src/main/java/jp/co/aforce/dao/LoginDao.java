package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Login;

public class LoginDao extends DAO {
	//ログイン情報(Bean)を取得するメソッド
	public Login search(String member_id, String password) throws Exception{
		Login loginSet = null;
		Connection connection=getConnection();
		//SELECTの後に取り出したいもの、WHEREの後は条件
		String sql="SELECT * FROM users WHERE MEMBER_ID=? AND PASSWORD=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,member_id);
		statement.setString(2,password);
		//検索結果を入れる
		ResultSet rs=statement.executeQuery();
		
		
		//検索結果をBeanの中に入れたのをListにいれる
		while (rs.next()) {
			loginSet = new Login();
			loginSet.setMember_id(rs.getString("member_id"));
			loginSet.setPassword(rs.getString("password"));
			loginSet.setLast_name(rs.getString("last_name"));
			loginSet.setFirst_name(rs.getString("first_name"));
			loginSet.setAdress(rs.getString("adress"));
			loginSet.setMail_adres(rs.getString("mail_adress"));
		}
		connection.close();
		statement.close();
		return loginSet;
	}
}
