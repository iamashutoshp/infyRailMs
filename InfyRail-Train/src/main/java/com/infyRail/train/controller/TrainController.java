package com.infyRail.train.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infyRail.train.dto.RouteDTO;
import com.infyRail.train.dto.TrainDTO;
import com.infyRail.train.service.TrainService;

@RestController
@RequestMapping("/trains")
@Validated
public class TrainController {

	@Autowired
	TrainService trainService;
	@Autowired
	private Environment environment;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> createTrain(@RequestBody TrainDTO trainDTO) {
		Integer routId=trainDTO.getRouteId();
		System.out.println(routId);
//		fetching route from InfyRail-route microservice
//		RouteDTO routeDTO=new RestTemplate().getForObject("url",RouteDTO.class);
//		if(routeDTO==null)
//			return ResponseEntity.ok(environment.getProperty("route.not.found"));
		return ResponseEntity.ok(trainService.createTrain(trainDTO));
	}
	@PutMapping(value = "/{trainid}")
	public ResponseEntity<String> updateTrain(@PathVariable("trainid") String id,@RequestParam String fare)  								  
	{
		
		System.out.println("fare "+fare);
		return ResponseEntity.ok(trainService.updateTrain(id,fare));
	}
	
	@GetMapping
	public List<TrainDTO> getRoutes(@RequestParam("routeId")Integer id){
		return trainService.getRoutes(id);
	}
	
}
