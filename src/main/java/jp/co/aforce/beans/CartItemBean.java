package jp.co.aforce.beans;

public class CartItemBean {
	
	private int MEMBER_ID;
	private int item_id;
	private int quantity;
	public int getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(int mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
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
	
	

}
