package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.TourPackages;

@Repository
public interface PackageRepository extends JpaRepository<TourPackages,Integer> {
Optional<TourPackages> findById(Integer id);
}
