package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Guide;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Integer>{

}
