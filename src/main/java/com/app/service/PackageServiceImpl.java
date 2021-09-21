package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PackageRepository;
import com.app.pojos.TourPackages;
@Service
@Transactional
public class PackageServiceImpl implements IPackageService {
	@Autowired
    private PackageRepository packageRepo;
	
	public List<TourPackages> getAllPackages() {
		List<TourPackages> packageslist=new ArrayList<>();
		packageslist=packageRepo.findAll();
		return packageslist;
	}

}
