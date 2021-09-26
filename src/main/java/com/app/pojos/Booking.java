package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="booking_tbl")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseEntity {

@ManyToOne
@JoinColumn(name="user_id")
private User userId;

@ManyToOne
@JoinColumn(name="guide_id")
private Guide guideId;

@ManyToOne
@JoinColumn(name="package_id")
private TourPackages packageId;

@Column
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate fromDate;

@Column
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate toDate;

@Enumerated(EnumType.STRING)
@Column(length=60)
private BookingStatus status; 

@Column 
private LocalDateTime bookingDateAndTime; 

@Column(length=600)
private String pickUpLocation;
	
}
