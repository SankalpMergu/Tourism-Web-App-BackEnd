package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_us")
public class ContactUs {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email",unique = true)
	private String email;
	@Column(name="subject")
	private String subject;
	
	public ContactUs()
	{
		
	}

	public ContactUs(int id, String name, String email, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + "]";
	}

}
