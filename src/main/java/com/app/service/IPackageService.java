package com.app.service;

import java.util.List;

import com.app.pojos.Booking;
import com.app.pojos.TourPackages;

public interface IPackageService {
List<TourPackages> getAllPackages();
TourPackages fetchPackageById(int Id);
}
