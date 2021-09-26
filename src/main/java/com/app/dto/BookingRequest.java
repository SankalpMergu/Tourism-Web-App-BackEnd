package com.app.dto;
//packageId:location.state,fromDate:fromDate,toDate:toDate,pickUpLocation:address

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class BookingRequest {
private int packageId;
private LocalDate fromDate;
private LocalDate toDate;
private String pickUpLocation;
private String userEmail;
}
