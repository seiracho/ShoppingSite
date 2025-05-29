package jp.co.aforce.beans;

import java.io.Serializable;

public class Login implements Serializable {
	
	private String member_id;
	private String password;
	private String last_name;
	private String first_name;
	private String adress;
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail_adres() {
		return mail_adres;
	}

	public void setMail_adres(String mail_adres) {
		this.mail_adres = mail_adres;
	}

	private String mail_adres;

	public String getMember_id() {
		return member_id;
	}
	
	public void setMember_id(String member_id) {
		this.member_id=member_id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name=last_name;
	}

}
