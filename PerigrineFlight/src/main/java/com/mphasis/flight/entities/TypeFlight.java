package com.mphasis.flight.entities;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.flight.util.StringPrefixedSequenceIdGenerator;

@Entity

public class TypeFlight implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tf_seq")
	@GenericGenerator(
			name = "tf_seq",
			strategy = "com.mphasis.flight.util.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TF_"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
	private String tfid;
	@Column(nullable=false)
	private int noofseats;
	@Column(nullable=false)
	private String typeofseat;
	@Column(nullable=false)
	private int bookedseats;
	
	@ManyToOne
	@JoinColumn(name="fid")
	private Flight flight;

	public String getTfid() {
		return tfid;
	}

	public void setTfid(String tfid) {
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

	public int getBookedseats() {
		return bookedseats;
	}

	public void setBookedseats(int bookedseats) {
		this.bookedseats = bookedseats;
	}

	
	
	
	
}
