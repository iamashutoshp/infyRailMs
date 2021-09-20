package com.infyRail.route.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.infyRail.route.entity.RouteEntity;


public class RouteDTO {
	
	@Min(value = 100)
	@Max(value = 999)
	Integer id;
	@NotEmpty(message="{route.source.must}")
	@Pattern(regexp="^[A-Za-z]+$",message= "{route.source.invalid}")
	String source;
	@NotEmpty(message="{route.destination.must}")
	@Pattern(regexp="^[A-Za-z]+$",message= "{route.destination.invalid}")
	String destination;
//	@NotEmpty
	List<TrainDTO> trainList=new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<TrainDTO> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<TrainDTO> trainList) {
		if(trainList!=null)
			this.trainList = trainList;
	}
	
	@Override
	public String toString() {
		return "routeDTO [id=" + id + ", source=" + source + ", destination=" + destination + ", trainList=" + trainList
				+ "]";
	}
	
	public static RouteEntity prepareRouteEntity(RouteDTO routeDTO) {
		RouteEntity routeEntity=new RouteEntity();
		
		routeEntity.setDestination(routeDTO.getDestination());
		routeEntity.setSource(routeDTO.getSource());
		
		return routeEntity;
	}
	
	public static RouteDTO prepareRouteDTO(RouteEntity routeEntity) {
		RouteDTO routeDTO=new RouteDTO();
		
		routeDTO.setDestination(routeEntity.getDestination());
		routeDTO.setSource(routeEntity.getSource());
		routeDTO.setId(routeEntity.getId());
		
		return routeDTO;
	}
}

