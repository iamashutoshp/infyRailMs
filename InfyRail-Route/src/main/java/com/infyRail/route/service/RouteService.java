package com.infyRail.route.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infyRail.route.dto.RouteDTO;
import com.infyRail.route.dto.TrainDTO;
import com.infyRail.route.entity.RouteEntity;
import com.infyRail.route.repository.RouteRepo;

@Service
public class RouteService {

	@Autowired
	RouteRepo routeRepo;
	
	public String createRoute(RouteDTO routeDTO) {
//		RouteEntity en=RouteDTO.change(routeDTO);
//		routeRepo.saveAndFlush(en);
//		System.out.println("id "+en.getId());
//		return Integer.toString(en.getId());
		RouteEntity routeEntity=RouteDTO.prepareRouteEntity(routeDTO);
		routeRepo.saveAndFlush(routeEntity);
		
		return routeEntity.getId()+"";
	}
	public RouteDTO fetchRoute(String idStr,List<TrainDTO> trainDTOs) {
		Integer id=Integer.parseInt(idStr);
		Optional<RouteEntity> en=routeRepo.findById(id);
		RouteDTO dto=null;
		if(en.isPresent()) {
			dto=RouteDTO.prepareRouteDTO(en.get());
			dto.setTrainList(trainDTOs);
		}
		
		System.out.println("returning from RouteService.fetchroute() for : "+id);
		return dto;
		
	}
	public List<TrainDTO> fetchTrain(String source,String destination) {
//		Optional<RouteEntity> ent=routeRepo.findBySourceAndDestination(source, destination);
//		if(ent.isPresent()) {
//			List<TrainDTO> trainDTO=TrainDTO.changeTo(ent.get().getTrainList());
//			return trainDTO;
//		}
		System.out.println("returning from RouteService.fetchTrain() for : source : "+source+"\n Destination : "+destination);
		return null;
	}
	public RouteDTO updateRoute(String id,String source,String destination) {
//		Optional<RouteEntity> ent=routeRepo.findById(Integer.parseInt(id));
//		if(ent.isPresent()) {
//			RouteEntity entity=ent.get();
//			entity.setSource(source);
//			entity.setDestination(destination);
//			routeRepo.saveAndFlush(entity);
//			RouteDTO routeDTO=RouteDTO.changeTo(entity);
//			return routeDTO;
//		}
		System.out.println("returning from RouteService.updateRoute() for : source : "+source+"\n Destination : "+destination);
		return null;
	}
	public RouteDTO updateRoute1(String id,RouteDTO routeDTO) {
//		Optional<RouteEntity> ent=routeRepo.findById(Integer.parseInt(id));
//		if(ent.isPresent()) {
//			RouteEntity en=RouteDTO.change(routeDTO);
//			RouteEntity entity=ent.get();
//			if(en.getDestination()!=null) {
//				entity.setDestination(en.getDestination());
//			}
//			if(en.getId()!=null) {
//				entity.setId(en.getId());
//			}
//			if(en.getSource()!=null) {
//				entity.setSource(en.getSource());
//			}
//			if(en.getTrainList()!=null) {
//				List<TrainEntity> te=en.getTrainList();
//				 te.addAll(entity.getTrainList());
//				entity.setTrainList(te);
//			}
//			routeRepo.saveAndFlush(entity);
//			RouteDTO routeDTO1=RouteDTO.changeTo(entity);
//			return routeDTO1;
//		}
		System.out.println("returning from RouteService.updateRoute1() for : route : "+routeDTO);
		
		return null;
	}
	public RouteDTO deleteTrain(String route,String train) {
//		Optional<RouteEntity> ent=routeRepo.findById(Integer.parseInt(route));
//		if(ent.isPresent()) {
//			RouteEntity entity=ent.get();
//			List<TrainEntity> trainEnt=entity.getTrainList();
//			trainEnt.removeIf(o->o.getId()==Integer.parseInt(train));
//			entity.setTrainList(trainEnt);
//			routeRepo.saveAndFlush(entity);	
//			RouteDTO dto=RouteDTO.changeTo(entity);
//			return dto;
//		}
		
		System.out.println("returning from RouteService.deleteTrain() for : route : "+route +" \n train : "+train);
		return null;
	}
}
