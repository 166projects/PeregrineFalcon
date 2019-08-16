package com.mphasis.flight.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.flight.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@GenericGenerator(
			name = "book_seq",
			strategy = "com.mphasis.flight.util.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
	private String bid;
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

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
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

	
	
}
