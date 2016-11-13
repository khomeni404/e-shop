package bd.com.softengine.shop.model;

import javax.persistence.*;


//@JsonAutoDetect
//@Entity
//@Table(name="CONTACT")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="CONTACT_NAME", nullable=false)
	private String name;
	
	@Column(name="CONTACT_PHONE", nullable=false)
	private String phone;
	
	@Column(name="CONTACT_EMAIL", nullable=false)
	private String email;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
