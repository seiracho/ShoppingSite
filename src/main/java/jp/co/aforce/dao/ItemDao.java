package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;

public class ItemDao extends DAO{
	//商品一覧表示メソッド
	public List<ItemBean>getAllItems () throws SQLException {
		List<ItemBean>itemList=new ArrayList<>();
		String sqlString="SELECT * FROM items";
		try(
				Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(sqlString);
				ResultSet rSet=statement.executeQuery();
		) {
			while (rSet.next()) {
				ItemBean bean=new ItemBean();
				
				bean.setItem_id(rSet.getInt("item_id"));
				bean.setName(rSet.getString("name"));
				bean.setPrice(rSet.getInt("price"));
				bean.setBrand_id(rSet.getInt("brand_id"));
//				bean.setBrand_name(rSet.getString("brand_name"));
				bean.setStock(rSet.getInt("stock"));
				bean.setSdgs_category(rSet.getString("sdgs_category"));
				bean.setDescription(rSet.getString("description"));
				bean.setImage_url(rSet.getString("image_url"));
				bean.setSub_image1(rSet.getString("sub_image1"));
				bean.setSub_image2(rSet.getString("sub_image2"));
				bean.setSub_image3(rSet.getString("sub_image3"));
				bean.setSub_image4(rSet.getString("sub_image4"));
				//Listに値をadd
				itemList.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("商品一覧の取得に失敗しました",e);
		}
		return itemList;
	}
	
	//商品検索メソッド
	public List<ItemBean> searchItems(String keyword, String brand_id, String sdgs_category, String sort) throws Exception{
		List<ItemBean> searchList =new ArrayList<>();
		//WHERE 1=1:後で「AND ○○」と自由追加可能
		StringBuilder sqlString=new StringBuilder("select i.*,brand_name from items i join brands b on i.brand_id= b.brand_id where 1=1");
		//商品名検索
		if (keyword !=null && !keyword.isEmpty()) {
			//ANDの後ろに条件
			sqlString.append(" AND i.name LIKE ?");
		}
		//brand
		if (brand_id !=null && !brand_id.isEmpty()) {
			sqlString.append(" AND i.brand_id=?");
		}
		//sdgs_category
		if (sdgs_category !=null && !sdgs_category.isEmpty()) {
			sqlString.append(" AND i.sdgs_category = ?");
		}
		//sort
		if (sort !=null && !sort.isEmpty()) {
			switch (sort) {
			case "price_asc":
				sqlString.append(" ORDER BY i.price ASC");
				break;
			case"price_desc":
				sqlString.append(" ORDER BY i.price DESC");
				break;
			case"name_asc":
				sqlString.append(" ORDER BY i.name ASC");
				break;
			}
		}
		
		try (
				Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(sqlString.toString());
		) {
			int index=1;
			if (keyword !=null && !keyword.isEmpty()) {
				//setString(index++, 値)で?に安全に値をバインド
				//[index++]:条件の数に応じて?の位置を自動で調整
				statement.setString(index++,  "%"+keyword+"%");
			}
			if (brand_id !=null && !brand_id.isEmpty()) {
				statement.setInt(index++, Integer.parseInt(brand_id));
			}
			if (sdgs_category !=null && !sdgs_category.isEmpty()) {
				statement.setString(index++,  sdgs_category);
			}
			
			ResultSet resultSet=statement.executeQuery();
			
			while (resultSet.next()) {
				ItemBean searchbean =new ItemBean();
				searchbean.setItem_id(resultSet.getInt("item_id"));
				searchbean.setName(resultSet.getString("name"));
				searchbean.setPrice(resultSet.getInt("price"));
				searchbean.setImage_url(resultSet.getString("image_url"));
				searchbean.setBrand_name(resultSet.getString("brand_name"));
				searchList.add(searchbean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("商品検索に失敗しました。", e);
		}
		return searchList;
	}
	
	
	//商品情報詳細表示メソッド
	public ItemBean getItemById(int item_id) throws Exception{
		ItemBean itemBean=null;
		String sqlString="SELECT i.*, b.brand_name FROM items i JOIN brands b ON i.brand_id = b.brand_id WHERE i.item_id = ?";
		try (
				Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(sqlString);
				){
			statement.setInt(1, item_id);
			ResultSet resultSet=statement.executeQuery();
			if (resultSet.next()) {
				itemBean= new ItemBean();
				itemBean.setItem_id(resultSet.getInt("item_id"));
				itemBean.setName(resultSet.getString("name"));
				itemBean.setPrice(resultSet.getInt("price"));
				itemBean.setBrand_id(resultSet.getInt("brand_id"));
				itemBean.setBrand_name(resultSet.getString("brand_name"));
				itemBean.setDescription(resultSet.getString("description"));
				itemBean.setSdgs_category(resultSet.getString("sdgs_category"));
				itemBean.setImage_url(resultSet.getString("image_url"));
				itemBean.setSub_image1(resultSet.getString("sub_image1"));
				itemBean.setSub_image2(resultSet.getString("sub_image2"));
				itemBean.setSub_image3(resultSet.getString("sub_image3"));
				itemBean.setSub_image4(resultSet.getString("sub_image4"));
			}
		}
		return itemBean;
	}
	

		//商品情報登録メソッド
		public void addItem(ItemBean item)throws Exception{
			Connection connection=getConnection();
			String sqlString="INSERT INTO items (name, price, brand_id, sdgs_category, description, stock, image_url, sub_image1, sub_image2, sub_image3, sub_image4) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement=connection.prepareStatement(sqlString);
			statement.setString(1, item.getName());
			statement.setInt(2, item.getPrice());
			statement.setInt(3, item.getBrand_id());
			statement.setString(4, item.getSdgs_category());
			statement.setString(5, item.getDescription());
			statement.setInt(6, item.getStock());
			statement.setString(7, item.getImage_url());
			statement.setString(8, item.getSub_image1());
			statement.setString(9, item.getSub_image2());
			statement.setString(10, item.getSub_image3());
			statement.setString(11, item.getSub_image4());
			
			statement.executeUpdate();
			
			statement.close();
			connection.close();
		}
	
		//商品情報更新メソッド
		public void updateItem(ItemBean item)throws Exception{
			Connection connection=getConnection();
			String sqlString="UPDATE items SET name=?, price=?, brand_id=?, sdgs_category=?, description=?, stock=?, image_url=?, sub_image1=?, sub_image2=?, sub_image3=?, sub_image4=? WHERE item_id=?";
			PreparedStatement statement=connection.prepareStatement(sqlString);
			statement.setString(1, item.getName());
			statement.setInt(2, item.getPrice());
			statement.setInt(3, item.getBrand_id());
			statement.setString(4, item.getSdgs_category());
			statement.setString(5, item.getDescription());
			statement.setInt(6, item.getStock());
			statement.setString(7, item.getImage_url());
			statement.setString(8, item.getSub_image1());
			statement.setString(9, item.getSub_image2());
			statement.setString(10, item.getSub_image3());
			statement.setString(11, item.getSub_image4());
			statement.setInt(12, item.getItem_id());
			
			statement.executeUpdate();
			
			statement.close();
			connection.close();
		}
		
		//商品情報削除メソッド
		public void deleteItem(ItemBean item)throws Exception{
			Connection connection=getConnection();
			String sqlString="DELETE FROM items WHERE item_id=?";
			PreparedStatement statement=connection.prepareStatement(sqlString);
			//値セット
			statement.setInt(1, item.getItem_id());
			statement.executeUpdate();
		}
		
		
}