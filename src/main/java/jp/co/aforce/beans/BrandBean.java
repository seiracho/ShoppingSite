package jp.co.aforce.beans;

import java.io.Serializable;

public class BrandBean implements Serializable{
	
	private int brand_id;
	private String brand_name;
	private String description;
	private String brand_logo_url;
	
	public BrandBean() {
		
	}
	
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand_logo_url() {
		return brand_logo_url;
	}
	public void setBrand_logo_url(String brand_logo_url) {
		this.brand_logo_url = brand_logo_url;
	}
	
	

}
