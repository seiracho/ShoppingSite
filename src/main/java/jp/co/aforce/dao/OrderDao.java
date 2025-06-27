package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jp.co.aforce.beans.OrderBean;
import jp.co.aforce.beans.OrderItemBean;

public class OrderDao extends DAO {
	
	//ordersに登録するメソッド
	// 注文（orders）を登録し、自動採番された注文IDを返す
	public int insertOrder(OrderBean orderBean)throws Exception{
		int generatedOrderId= -1;
		try ( Connection connection=getConnection();)
		{
			String sqlString="INSERT INTO orders(order_id, MEMBER_ID, order_date, total_price) VALUE(?, ?, ?, ?)";
			PreparedStatement statement=connection.prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, orderBean.getOrder_id());
			statement.setInt(2, orderBean.getMember_id());
			statement.setString(3, orderBean.getOrder_date());
			statement.setInt(4, orderBean.getTotal_price());
			
			statement.executeUpdate();
			
			ResultSet resultSet=statement.getGeneratedKeys();
			if (resultSet.next()) {
				generatedOrderId=resultSet.getInt(1);
			}
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generatedOrderId;
	}
	
	//order_itemsに登録するメソッド
	public void insertOrderItem(OrderItemBean orderItemBean)throws Exception{
		try(Connection connection=getConnection())
		{
			String sqlString="INSERT INTO order_items(order_id, item_id, quantity, price_at_order) VALUE (?, ?, ?, ?)";
			PreparedStatement statement=connection.prepareStatement(sqlString);
			statement.setInt(1, orderItemBean.getOrder_id());
			statement.setInt(2, orderItemBean.getItem_id());
			statement.setInt(3, orderItemBean.getQuantity());
			statement.setInt(4, orderItemBean.getPrice_at_order());
			
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
