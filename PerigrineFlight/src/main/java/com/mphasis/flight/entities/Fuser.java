package com.mphasis.flight.entities;

import java.io.Serializable;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.flight.util.StringPrefixedSequenceIdGenerator;


@Entity
public class Fuser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fuser_seq")
	@GenericGenerator(
			name = "fuser_seq",
			strategy = "com.mphasis.flight.util.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "USER_"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})
	private String cid;
	@Column(nullable = false)
	private String cname;
	@Column(unique = true, nullable = false)
	private String cemail;
	@Column(nullable = false)
	private String cpass;
	@Column(nullable = false)
	private String dob;
	@Column(length = 10)
	private long phonenum;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String role;

	@OneToMany(mappedBy = "fuser")
	@JsonIgnore
	private List<Booking> booking;

	// @OneToOne
	// @JoinColumn(name="rid")
	// private Route route;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
