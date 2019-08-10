package com.mphasis.flight.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rid;
	@Column(nullable=false)
	private String source;
	@Column(nullable=false)
	private String destination;
	
	@OneToMany(mappedBy="route",fetch=FetchType.LAZY)
	@JsonIgnore
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

	
	

	
}
