package com.app.dto;

import com.app.pojos.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedBookingDetails {
      private int bookingId;
      private int guideId;
      private BookingStatus bookingStatus;
}
