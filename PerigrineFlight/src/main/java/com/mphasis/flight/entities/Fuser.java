package com.mphasis.flight.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Fuser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
       private int cid;
	   @Column(nullable=false)
       private String cname;
       @Column(unique=true, nullable=false)
       private String cemail;
       @Column(nullable=false)
       private String cpass;
       @Column(nullable=false)
       private LocalDate dob;
       @Column(length=10)
       private long phonenum;
       @Column(nullable=false)
       private String gender;
       
       @OneToMany(mappedBy="fuser")
       private List<Booking> booking;
       
//       @OneToOne
//       @JoinColumn(name="rid")
//       private Route route;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(long phonenum) {
		this.phonenum = phonenum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

//	public Route getRoute() {
//		return route;
//	}
//
//	public void setRoute(Route route) {
//		this.route = route;
//	}

	@Override
	public String toString() {
		return "Fuser [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpass=" + cpass + ", dob=" + dob
				+ ", phonenum=" + phonenum + ", gender=" + gender + ", booking=" + booking + " ]";
	}
       
       
}
