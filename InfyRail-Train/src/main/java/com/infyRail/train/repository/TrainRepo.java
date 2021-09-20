package com.infyRail.train.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infyRail.train.dto.TrainDTO;
import com.infyRail.train.entity.TrainEntity;

public interface TrainRepo extends JpaRepository<TrainEntity,Integer>{
	
	public List<TrainEntity> findByRouteId(Integer id);
}
