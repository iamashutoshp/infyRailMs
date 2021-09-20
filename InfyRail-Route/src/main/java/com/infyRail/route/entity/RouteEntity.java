package com.infyRail.route.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class RouteEntity {
    @Id
    @GenericGenerator(name = "route_id", strategy = "com.infyRail.route.entity.generator.CustomIDGenerator")
    @GeneratedValue(generator = "route_id")
    @Column(name="route_id")
	Integer id;
	String source;
	String destination;
	
	
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


	
	@Override
	public String toString() {
		return "RouteEntity [id=" + id + ", source=" + source + ", destination=" + destination + ", trainList="
				+ "]";
	}
	
}
