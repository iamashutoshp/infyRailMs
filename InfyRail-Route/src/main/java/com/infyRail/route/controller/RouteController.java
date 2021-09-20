package com.infyRail.route.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infyRail.route.dto.RouteDTO;
import com.infyRail.route.dto.TrainDTO;
import com.infyRail.route.service.RouteService;


@RestController
@RequestMapping("/routes")
@Validated
public class RouteController {
	@Autowired
	RouteService routeService;

	@Value("${trainms.uri}")
	private String trainUri;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> createRoute(@Valid @RequestBody RouteDTO routeDTO){
		return ResponseEntity.ok(routeService.createRoute(routeDTO));
	}
	
	
	@GetMapping(value = "/{routeId}")
	public ResponseEntity<RouteDTO> fetchRoute(@PathVariable("routeId") String id){
		
//		fetching route from InfyRail-TrainMS
		System.out.println(trainUri+"?routeId="+id);
		TrainDTO[] forNow =new RestTemplate().getForObject(trainUri+"?routeId="+id, TrainDTO[].class);
	    List<TrainDTO> trainDTOs= Arrays.asList(forNow);
		return ResponseEntity.ok(routeService.fetchRoute(id,trainDTOs));
	}
	
	
	@GetMapping(value = "/trains")
	public ResponseEntity<List<TrainDTO>> fetchTrain(@RequestParam String source,@RequestParam String destination){
		return ResponseEntity.ok(routeService.fetchTrain(source,destination));
	}
	
	
	@PutMapping(value = "/{routeId}")
	public ResponseEntity<RouteDTO> updateRoute(@PathVariable("routeId") String id,@MatrixVariable Map<String, String> map) 
	 								  
	{
			return ResponseEntity.ok(routeService.updateRoute(id,map.get("source"),map.get("destination")));		
	}
	
	
	@PutMapping(value = "/{routeid}/json")
	public ResponseEntity<RouteDTO> updateTrain(@PathVariable("routeid") String id,@Valid @RequestBody RouteDTO routeDTO)  								  
	{
		return ResponseEntity.ok(routeService.updateRoute1(id,routeDTO));
	}
	@DeleteMapping(value="/{routeId}/{trainId}")
	public ResponseEntity<RouteDTO> deleteTrain(@PathVariable("routeId") String route,@PathVariable("trainId") String train){
		return ResponseEntity.ok(routeService.deleteTrain(route, train));
	}
}
