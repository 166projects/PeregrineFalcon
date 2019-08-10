package com.mphasis.flight.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Passenger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String gender;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	private long phone;
	@Column(nullable=false)
	private int seatno;
	private String passport;
	
	
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

}
