package com.mphasis.flight.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.flight.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Flight implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
	@GenericGenerator(
			name = "flight_seq",
			strategy = "com.mphasis.flight.util.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "F_"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
	private String fid;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private int distance;
	@Column(nullable=false)
	private String typeofflight;
	
	

	@OneToMany(mappedBy="flight")
	@JsonIgnore
	private List<TypeFlight> typeflight;
	
	@OneToMany(mappedBy="flight")
	@JsonIgnore
	//@JoinColumn(name="sid")
	private List<Schedule> schedule;
	
	@ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="rid")
	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
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

	public String getTypeofflight() {
		return typeofflight;
	}

	public void setTypeofflight(String typeofflight) {
		this.typeofflight = typeofflight;
	}                             

	
	
}
