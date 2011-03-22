package org.xaab.springmvc;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
//import org.xaab.springmvc.constraints.CheckCase;
//import org.xaab.springmvc.constraints.CaseMode;

public class PersonalContact implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Long id;

	@NotBlank(message="Please enter name")
	private String name;

	@Pattern(regexp="[0-9]{8}", message="Please enter 8 digit phone number")
	private String phone;

	@Email
	private String email;

	public PersonalContact() {}

	public PersonalContact(Long id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
