package jp.co.aforce.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	static DataSource dSource;
	
	public Connection getConnection() throws Exception{
		if (dSource==null) {
			InitialContext iContext=new InitialContext();
			dSource=(DataSource)iContext.lookup("java:/comp/env/jdbc/shoppingsite_cho");
		}
		//DataSourceインターフェースのメソッドを使用し接続を取得＋呼び出し元に返す
		return dSource.getConnection();
	}

}
