package com.mphasis.flight.entities;

import javax.persistence.*;

@Entity

public class TypeFlight {

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

	@Override
	public String toString() {
		return "TypeFlight [tfid=" + tfid + ", noofseats=" + noofseats + ", typeofseat=" + typeofseat + ", flight="
				+ flight + "]";
	}
	
	
	
	
}
