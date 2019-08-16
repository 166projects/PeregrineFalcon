package com.mphasis.flight.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.flight.util.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name="schedules")
public class Schedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sched_seq")
	@GenericGenerator(
			name = "sched_seq",
			strategy = "com.mphasis.flight.util.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "S_"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
    private String sid;
    @Column(nullable=false)
    private String fdate;
    @Column(nullable=false)
  //  @Temporal(TemporalType.TIME)
    private String arrival;
    
    @Column(nullable=false)
   // @Temporal(TemporalType.TIME)
    private String departure;
    
    
    @ManyToOne
    @JoinColumn(name="fid")
    private Flight flight;
    
    
    
    public String getSid() {
                    return sid;
    }
    public void setSid(String sid) {
                    this.sid = sid;
    }
    
	
    public String getArrival() {
                    return arrival;
    }
    public void setArrival(String arrival) {
                    this.arrival = arrival;
    }
    public String getDeparture() {
                    return departure;
    }
    public void setDeparture(String departure) {
                    this.departure = departure;
    }
    public Flight getFlight() {
                    return flight;
    }
    public void setFlight(Flight flight) {
                    this.flight = flight;
    }
    public String getFdate() {
		return fdate;
	}
	public void setF_date(String fdate) {
		this.fdate = fdate;
	}
	
	   

}

