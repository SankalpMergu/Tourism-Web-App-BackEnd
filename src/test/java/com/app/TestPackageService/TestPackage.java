package com.app.TestPackageService;

 
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.TourPackages;
import com.app.service.IPackageService;
@SpringBootTest
class TestPackage {
	@Autowired
    private IPackageService packageService;
	@Test
	void testPackages() {
		List<TourPackages> list=new ArrayList<>();
		list=packageService.getAllPackages(); 
		System.out.println(list);
	}

}
