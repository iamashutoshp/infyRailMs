package com.infyRail.train.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infyRail.train.dto.RouteDTO;
import com.infyRail.train.dto.TrainDTO;
import com.infyRail.train.entity.TrainEntity;
import com.infyRail.train.repository.TrainRepo;

@Service
public class TrainService {

	@Autowired
	TrainRepo trainRepo;
	@Autowired
	private Environment environment;
	
	public String createTrain(TrainDTO trainDTO) {
//		TrainEntity en=TrainDTO.changesTo(trainDTO);
//		trainRepo.saveAndFlush(en);
//		System.out.println("id "+en.getId());
//		return Integer.toString(en.getId());
		
		TrainEntity trainEntity=TrainDTO.prepareTrainEntity(trainDTO);
		trainRepo.saveAndFlush(trainEntity);
		
		System.out.println("created train in TrainService.createTrain() for trainObj : "+trainDTO);
		return Integer.toString(trainEntity.getId());
	}
	
	public String updateTrain(String id, String fare) {
		
//		Optional<TrainEntity> en=trainRepo.findById(Integer.parseInt(id));
//		try {
//			TrainEntity tent=en.get();
//			tent.setFare(Double.parseDouble(fare));
//			trainRepo.saveAndFlush(tent);
//			return "Success: Fare gets Updated";
//		} catch (Exception e) {
//			return "Failed: Could not update the fare";
//			// TODO: handle exception
//		}
		Optional<TrainEntity> trainOptional=trainRepo.findById(Integer.parseInt(id));
		TrainEntity trainEntity=null;
		try {
			trainEntity=trainOptional.get();
			trainEntity.setFare(Double.parseDouble(fare));
			trainRepo.saveAndFlush(trainEntity);
		} catch (Exception e) {
			return environment.getProperty("train.fare.NotUpdated")+" : "+fare;
		}
		return environment.getProperty("train.fare.updated")+" : "+fare;
	}
	
	public List<TrainDTO> getRoutes(Integer id) {
		List<TrainEntity> getRoutes=trainRepo.findByRouteId(id);
		List<TrainDTO> getRoutesRes=new ArrayList<>();
		for(TrainEntity trainEntity : getRoutes)
			getRoutesRes.add(TrainDTO.prepareTrainDTO(trainEntity));
		return getRoutesRes;
	}
	
	
}

//{
//"source": "delhi",
//"destination": "jaipur",
//"trainList":[{
//    "id":"3",
//    "trainName":"A",
//    "arrivalTime":"8:00 AM",
//    "departureTime":"10:00 PM",
//    "fare":"2500.00"
//},{
//    "id":"4",
//    "trainName":"B",
//    "arrivalTime":"9:00 AM",
//    "departureTime":"11:00 PM",
//    "fare":"2500.00"
//}]
//}