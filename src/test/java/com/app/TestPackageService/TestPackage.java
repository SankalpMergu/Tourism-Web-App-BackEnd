package com.app.TestPackageService;

 
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dao.BookingRepository;
import com.app.pojos.Booking;
import com.app.pojos.TourPackages;
import com.app.restcontroller.BookingRestController;
import com.app.service.IPackageService;
@SpringBootTest
class TestPackage {
	@Autowired
    private IPackageService packageService;
	
	@Autowired
	private BookingRepository bookRepo;
	
	@Test
	void testPackages() {
		List<TourPackages> list=new ArrayList<>();
		list=packageService.getAllPackages(); 
		System.out.println(list);
	}
	
	@Test
	void testgetPackageById() {
		TourPackages tour=packageService.fetchPackageById(1); 
		System.out.println(tour);
	}
    
	@Test
	void testgetBookings() {
		List<Booking> list=new ArrayList<>();
		 list=bookRepo.findAll();
		System.out.println(list);
	}
}
