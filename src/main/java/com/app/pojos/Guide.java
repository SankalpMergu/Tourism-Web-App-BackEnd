package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "guidetbl")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Guide extends BaseEntity {

	@Column(name="Guide_name")
	private String name;
	
	@Column(name="mobile_no")
	private String mobile;
	
	@Column(name="email")
	private String email;
	
	@Column(name="location_known")
	private String locationKnown;
	
}