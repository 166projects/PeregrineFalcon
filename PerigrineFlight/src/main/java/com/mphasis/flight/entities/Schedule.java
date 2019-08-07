package com.mphasis.flight.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedules")
public class Schedule {

    @Id
    private int sid;
    @Column(nullable=false)
    private LocalDate fdate;
    @Column(nullable=false)
    private LocalDateTime arrival;
    @Column(nullable=false)
    private LocalDateTime departure;
    
    @ManyToOne
    @JoinColumn(name="fid")
    private Flight flight;
    
    
    
    public int getSid() {
                    return sid;
    }
    public void setSid(int sid) {
                    this.sid = sid;
    }
    
	
    public LocalDateTime getArrival() {
                    return arrival;
    }
    public void setArrival(LocalDateTime arrival) {
                    this.arrival = arrival;
    }
    public LocalDateTime getDeparture() {
                    return departure;
    }
    public void setDeparture(LocalDateTime departure) {
                    this.departure = departure;
    }
    public Flight getFlight() {
                    return flight;
    }
    public void setFlight(Flight flight) {
                    this.flight = flight;
    }
    public LocalDate getFdate() {
		return fdate;
	}
	public void setF_date(LocalDate fdate) {
		this.fdate = fdate;
	}
	@Override
	public String toString() {
		return "Schedule [sid=" + sid + ", date=" + fdate + ", arrival=" + arrival + ", departure=" + departure
				+ ", flight=" + flight + "]";
	}
    
    
    

}
