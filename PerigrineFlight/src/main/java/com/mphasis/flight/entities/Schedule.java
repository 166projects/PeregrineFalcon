package com.mphasis.flight.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="schedules")
public class Schedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    private int sid;
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
    
    
    
    public int getSid() {
                    return sid;
    }
    public void setSid(int sid) {
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

