package jp.co.aforce.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.BrandBean;

public class BrandDao extends DAO{

	public List<BrandBean> getAllBrands() throws SQLException{
		List<BrandBean> brandList=new ArrayList<>();
		String sqlString="SELECT * FROM brands";
		try(
				Connection connection = getConnection();
				PreparedStatement statement=connection.prepareStatement(sqlString);
				ResultSet rSet=statement.executeQuery();		
		){
			while(rSet.next()) {
				BrandBean bean =new BrandBean();
				
				bean.setBrand_name(rSet.getString("brand_name"));
				bean.setDescription(rSet.getString("description"));
				bean.setBrand_logo_url(rSet.getString("brand_logo_url"));
				brandList.add(bean);
			}
		} catch (Exception e) {
			System.err.println("ブランド一覧取得エラー");
			e.printStackTrace();
			throw new SQLException("ブランド一覧の取得に失敗しました", e);
		}
//		rSet.close();
//		statement.close();
//		connection.close();
		
		return brandList;
	}
	
}
