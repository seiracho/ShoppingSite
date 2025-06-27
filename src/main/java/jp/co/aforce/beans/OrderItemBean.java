package jp.co.aforce.beans;

import java.io.Serializable;
//各注文商品詳細情報
public class OrderItemBean implements Serializable {
	private int order_id;
	private int item_id;
	private int quantity;
	private int price_at_order;
	
	public OrderItemBean() {
		
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice_at_order() {
		return price_at_order;
	}
	public void setPrice_at_order(int price_at_order) {
		this.price_at_order = price_at_order;
	}

}
