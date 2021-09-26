package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="User_tbl")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User extends BaseEntity {
@NotBlank(message="FirstName must be supplied")
@Column(length=60)
private String firstName;
@NotBlank(message="LastName must be supplied")
@Column(length=60)
private String lastName;
@NotBlank(message="Email must be supplied")
@Column(length=60,unique = true)
private String email;
@NotBlank(message="Password must be supplied")
@Column(length=15)
private String password;
@NotBlank(message="MobileNo must be supplied")
@Column(length=10)
private String mobileNo;
//@NotBlank(message="Role must be supplied")
@Enumerated(EnumType.STRING)
@Column(length=10)
private UserRole role;
@Column
private LocalDateTime registerDate; 
public User(String firstName, String lastName, String email, String password, String mobileNo, UserRole role) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.mobileNo = mobileNo;
	this.role = role;
	this.registerDate = LocalDateTime.now();
	
}

}
