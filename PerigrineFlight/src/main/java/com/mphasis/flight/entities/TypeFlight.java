package com.mphasis.flight.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity

public class TypeFlight implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tfid;
	@Column(nullable=false)
	private int noofseats;
	@Column(nullable=false)
	private String typeofseat;
	
	@ManyToOne
	@JoinColumn(name="fid")
	private Flight flight;

	public int getTfid() {
		return tfid;
	}

	public void setTfid(int tfid) {
		this.tfid = tfid;
	}

	public int getNoofseats() {
		return noofseats;
	}

	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}

	public String getTypeofseat() {
		return typeofseat;
	}

	public void setTypeofseat(String typeofseat) {
		this.typeofseat = typeofseat;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	
	
	
	
}
