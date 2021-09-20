package com.infyRail.train.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.infyRail.train.entity.TrainEntity;


public class TrainDTO implements Serializable{
	
	Integer id;
	String trainName;
	String arrivalTime;
	String departureTime;
	Double fare;
	Integer routeId;
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "TrainDTO [id=" + id + ", trainName=" + trainName + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", fare=" + fare + ", routeId=" + routeId + "]";
	}
	
	public static TrainEntity prepareTrainEntity(TrainDTO trainDTO) {
		TrainEntity trainEntity=new TrainEntity();
		trainEntity.setArrivalTime(trainDTO.getArrivalTime());
		trainEntity.setDepartureTime(trainDTO.getDepartureTime());
		trainEntity.setFare(trainDTO.getFare());
		trainEntity.setId(trainDTO.getId());
		trainEntity.setRouteId(trainDTO.getRouteId());
		trainEntity.setTrainName(trainDTO.getTrainName());
		return trainEntity;
	}
	
	public static TrainDTO prepareTrainDTO(TrainEntity trainEntity) {
		TrainDTO trainDTO=new TrainDTO();
		trainDTO.setArrivalTime(trainEntity.getArrivalTime());
		trainDTO.setDepartureTime(trainEntity.getDepartureTime());
		trainDTO.setFare(trainEntity.getFare());
		trainDTO.setId(trainEntity.getId());
		trainDTO.setRouteId(trainEntity.getRouteId());
		trainDTO.setTrainName(trainEntity.getTrainName());
		return trainDTO;
	}
}
