package jp.co.aforce.beans;

import java.io.Serializable;

//データ(会員情報)まとめて管理
//DBで見つかった情報を一時的に入れておく
public class Login implements Serializable {

	private String member_id;
	private String password;
	private String last_name;
	private String first_name;
	private String address;
	private String mail_address;

	//型のコンストラクタ(引数なし)
	public Login() {

	}

	//getter
	public String getFirst_name() {
		return first_name;
	}

	//setter
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
