package com.mphasis.flight.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.flight.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq")
	@GenericGenerator(
			name = "route_seq",
			strategy = "com.mphasis.flight.util.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "R_"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
	private String rid;
	@Column(nullable=false)
	private String source;
	@Column(nullable=false)
	private String destination;
	
	@OneToMany(mappedBy="route",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Flight> flight;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
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
