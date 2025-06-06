package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.UserBean;

public class UserDao extends DAO {
	
	//既に登録済みか確認するメソッド
	public UserBean loginCheck(String member_id, String password) throws Exception{
		UserBean addUserBean =null;
		
		Connection connection=getConnection();
		//SQL 条件チェック
		String sql="SELECT * FROM users WHERE MEMBER_ID=? AND PASSWORD=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, member_id);
		statement.setString(2, password);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			//ResultSetから結果取り出しBeanに値を入れてく
			addUserBean = new UserBean();
			//rs.getString():DBの中身取り出し
			//addUserBeanに保存
			addUserBean.setMember_id(rs.getString("member_id"));
			addUserBean.setPassword(rs.getString("password"));
			addUserBean.setLast_name(rs.getString("last_name"));
			addUserBean.setFirst_name(rs.getString("first_name"));
			addUserBean.setAddress(rs.getString("address"));
			addUserBean.setMail_address(rs.getString("mail_address"));
	}
		
		rs.close();
		statement.close();
		connection.close();
		
		return addUserBean;
	}
	
	public boolean userCheck(UserBean user)throws Exception {
		Connection connection=getConnection();
		String sqlString="SELECT MEMBER_ID FROM users WHERE MEMBER_ID=?";
		PreparedStatement statement=connection.prepareStatement(sqlString);
		statement.setString(1, user.getMember_id());
		ResultSet result=statement.executeQuery();
		//結果が存在すれば重複→trueを返す（既に登録されている）
		//next();一致する行があれば
		boolean isDuplicate=result.next();
		
		result.close();
		statement.close();
		connection.close();
		
		return isDuplicate;
	}
	
	
	
	
	
	
	//新規登録メソッド
	public boolean addUser(UserBean user)throws Exception {
		Connection connection=getConnection();
		String sql="INSERT INTO users (member_id, password, last_name, first_name, address, mail_address) VALUES(?,?,?,?,?,?)";
		//SQL文の中に値を安全に埋め込める（SQLインジェクション防止）
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getMember_id());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getLast_name());
		statement.setString(4, user.getFirst_name());
		statement.setString(5, user.getAddress());
		statement.setString(6, user.getMail_address());
		//executeUpdate()：更新系(insert/update/delete)で使うメソッド
		//executeUpdate()で何件データが変更されたかをint型で返す
		int result = statement.executeUpdate();
		
		statement.close();
		connection.close();
		//結果をboolean型で返す
		//変更結果が１以上だったらtrue,0以下がfalse
		return  result>0;
	}
	
	//更新メソッド
	public boolean updateUser(UserBean user)throws Exception {
		Connection connection=getConnection();
		String sql="UPDATE users SET password=?, last_name=?, first_name=?, address=?, mail_address=? WHERE member_id=?";
		//SQL文の中に値を安全に埋め込める（SQLインジェクション防止）
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getPassword());
		statement.setString(2, user.getLast_name());
		statement.setString(3, user.getFirst_name());
		statement.setString(4, user.getAddress());
		statement.setString(5, user.getMail_address());
		statement.setString(6, user.getMember_id());
		//executeUpdate()：更新系(insert/update/delete)で使うメソッド
		//executeUpdate()で何件データが変更されたかをint型で返す
		int edit = statement.executeUpdate();
		
		statement.close();
		connection.close();
		//結果をboolean型で返す
		//変更結果が１以上だったらtrue,0以下がfalse
		return  edit>0;
	}
	
	//削除メソッド
	public boolean deleteUser(UserBean user)throws Exception {
		//DB接続メソッド
		Connection connection=getConnection();
		//SQL 削除命令 プレースホルダ使用
		String sqlString="DELETE FROM users WHERE member_id=?";
		//SQLインジェクション対策
		PreparedStatement statement=connection.prepareStatement(sqlString);
		//値セット
		//1番目の?に user.getMember_id()の値をセット
		statement.setString(1, user.getMember_id());
		//SQL文成功して１行削除→１、no削除→0
		int delete=statement.executeUpdate();
		
		statement.close();
		connection.close();
		//１行以上削除→true
		return delete>0;
	}
	

}
