package jp.co.aforce.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

//DBとの接続専用クラス
//接続方法を共通で定義
public class DAO {
	static DataSource dSource;

	//JNDI DB接続情報を見つけて、接続を作る。他のDAOクラスでも共通使用可
	public Connection getConnection() throws Exception {
		if (dSource == null) {
			InitialContext iContext = new InitialContext();
			dSource = (DataSource) iContext.lookup("java:/comp/env/jdbc/shoppingsite_cho");
		}
		//DataSourceインターフェースのメソッドを使用し接続を取得＋呼び出し元に返す
		return dSource.getConnection();
	}

}
