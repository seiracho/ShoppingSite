package jp.co.aforce.beans;

import java.io.Serializable;

public class ItemBean implements Serializable{
	
	private int item_id;
	private String name;
	private int price;
	private int brand_id;
	private int stock;
	private String sdgs_category;
	private String description;
	private String image_url;
	private String sub_image1;
	private String sub_image2;
	private String sub_image3;
	private String sub_image4;
	
	private String brand_name;

	public ItemBean() {
		
	}
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getSdgs_category() {
		return sdgs_category;
	}
	public void setSdgs_category(String sdgs_category) {
		this.sdgs_category = sdgs_category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getSub_image1() {
		return sub_image1;
	}
	public void setSub_image1(String sub_image1) {
		this.sub_image1 = sub_image1;
	}
	
	public String getSub_image2() {
		return sub_image2;
	}
	public void setSub_image2(String sub_image2) {
		this.sub_image2 = sub_image2;
	}
	
	public String getSub_image3() {
		return sub_image3;
	}
	public void setSub_image3(String sub_image3) {
		this.sub_image3 = sub_image3;
	}
	
	public String getSub_image4() {
		return sub_image4;
	}
	public void setSub_image4(String sub_image4) {
		this.sub_image4 = sub_image4;
	}
	
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
}
