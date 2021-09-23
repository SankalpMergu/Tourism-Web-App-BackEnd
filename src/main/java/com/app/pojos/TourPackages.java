package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity  
@Table(name="tourpackages_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor     
@ToString
public class TourPackages extends BaseEntity {
@Column(length=10)
@Enumerated(EnumType.STRING)
private PackageType packageType;
@NotBlank(message="PackageName must be supplied")
@Column(length=15)
private String location;
@NotBlank(message="PackageName must be supplied")
@Column
private Double price;
@NotBlank(message="PackageName must be supplied")
@Column(length=2000)
private String packageDetails;
@NotBlank(message="Places Must be supplied")
@Column(length=1000)
private String placesToBeVisited;
@NotBlank(message ="Days and Nights must be supplied")
@Column(length=30)
private String daysAndNights;
}
