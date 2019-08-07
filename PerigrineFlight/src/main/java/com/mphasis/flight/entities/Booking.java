package com.mphasis.flight.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	@Column(nullable=false)
	private int totalfare;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Fuser fuser;
	
	@ManyToOne
	@JoinColumn(name="rid")
	private Route route;
	
	@OneToOne
	@JoinColumn(name="sid")
	private Schedule schedule;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Passenger passenger;
	
	@ManyToOne
	@JoinColumn(name="tfid")
	private TypeFlight typeflight;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(int totalfare) {
		this.totalfare = totalfare;
	}

	public Fuser getFuser() {
		return fuser;
	}

	public void setFuser(Fuser fuser) {
		this.fuser = fuser;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public TypeFlight getTypeflight() {
		return typeflight;
	}

	public void setTypeflight(TypeFlight typeflight) {
		this.typeflight = typeflight;
	}

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", totalfare=" + totalfare + ", fuser=" + fuser + ", route=" + route
				+ ", schedule=" + schedule + ", passenger=" + passenger + ", typeflight=" + typeflight + "]";
	}
	
	
}
