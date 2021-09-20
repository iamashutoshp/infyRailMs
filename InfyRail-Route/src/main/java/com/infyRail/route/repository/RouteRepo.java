package com.infyRail.route.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyRail.route.entity.RouteEntity;

@Repository
public interface RouteRepo extends JpaRepository<RouteEntity,Integer>{
	
	
	Optional<RouteEntity> findById(Integer id);
	Optional<RouteEntity> findBySourceAndDestination(String source,String destination);
}
