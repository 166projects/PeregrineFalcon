package com.mphasis.flight.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fid;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private int distance;
	
	@OneToMany(mappedBy="flight")
	private List<TypeFlight> typeflight;
	
	@OneToMany(mappedBy="flight")
	//@JoinColumn(name="sid")
	private List<Schedule> schedule;
	
	@ManyToOne
	 @JoinColumn(name="rid")
	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	

	public List<TypeFlight> getTypeflight() {
		return typeflight;
	}

	public void setTypeflight(List<TypeFlight> typeflight) {
		this.typeflight = typeflight;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Flight [fid=" + fid + ", name=" + name + ", distance=" + distance + ", typeflight=" + typeflight
				+ ", schedule=" + schedule + ", route=" + route + "]";
	}

	
	
}
