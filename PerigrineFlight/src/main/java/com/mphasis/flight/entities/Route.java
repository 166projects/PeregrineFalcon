package com.mphasis.flight.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rid;
	@Column(nullable=false)
	private String source;
	@Column(nullable=false)
	private String destination;
	
	@OneToMany(mappedBy="route")

	private List<Flight> flight;
	

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Route [rid=" + rid + ", source=" + source + ", destination=" + destination + ", flight=" + flight + "]";
	}

	
	
	
}
