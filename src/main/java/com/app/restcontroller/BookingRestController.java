package com.app.restcontroller;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BookingRepository;
import com.app.dao.GuideRepository;
import com.app.dao.PackageRepository;
import com.app.dao.UserRepository;
import com.app.dto.BookingRequest;
import com.app.dto.UpdatedBookingDetails;
import com.app.pojos.Booking;
import com.app.pojos.BookingStatus;
import com.app.pojos.Guide;
import com.app.pojos.TourPackages;
import com.app.pojos.User;

@RestController
@RequestMapping("/api/tour")
@CrossOrigin
public class BookingRestController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PackageRepository packRepo;
	
	@Autowired
	private BookingRepository bookRepo;
	
	@Autowired
	private GuideRepository guideRepo;

	@PostMapping("/booking")
	@Transactional
	public ResponseEntity<?> tourBooking(@RequestBody BookingRequest bookingDetails){
		//System.out.println("booking email"+userEmail);
		System.out.println(bookingDetails);
		User curruser=userRepo.findByEmail(bookingDetails.getUserEmail()).get();
		System.out.println(curruser);
		TourPackages currtour=packRepo.findById(bookingDetails.getPackageId()).get();
		//System.out.println(currtour);
		//System.out.println(curruser);
		try { 
			Booking bookUserTour=new Booking();
			bookUserTour.setPackageId(currtour);
			bookUserTour.setUserId(curruser);
			bookUserTour.setGuideId(null);
			bookUserTour.setFromDate(bookingDetails.getFromDate());
			bookUserTour.setToDate(bookingDetails.getToDate());
			bookUserTour.setStatus(BookingStatus.PENDING);
			bookUserTour.setBookingDateAndTime(LocalDateTime.now());
			bookUserTour.setPickUpLocation(bookingDetails.getPickUpLocation());
			
			return new ResponseEntity<>(bookRepo.save(bookUserTour), HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>("Failed to add Booking", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/bookings")
	public ResponseEntity<?> getBookings(){
		try {
			return new ResponseEntity<>(bookRepo.findAll(), HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>("Failed to get Booking", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateBooking")
	public void updateCurrBooking(@RequestBody UpdatedBookingDetails bookingUpdateRequest){
		      System.out.println(bookingUpdateRequest);
		      Guide guide=guideRepo.findById(bookingUpdateRequest.getGuideId()).get();
		      System.out.println(guide);
		      Booking details=bookRepo.findById(bookingUpdateRequest.getBookingId()).get(); 
		      System.out.println(details);
		      details.setGuideId(guide);
		      details.setStatus(bookingUpdateRequest.getBookingStatus());
		      bookRepo.save(details);
		      
	}
	
	@DeleteMapping("/{id}")
	public void cancelBooking(@PathVariable int id) {
		bookRepo.deleteById(id);
	}
	
	
}
