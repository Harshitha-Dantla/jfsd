package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name = "teacher_table")

//@DiscriminatorValue("TEACHER")

public class Car extends Vehical
{
	@Column(name = "cname",length = 50)
	private String name;
	@Column(name = "ctype",length = 50)
	private String ctype;
	@Column(name = "ccolor",length = 50)
	private String color;
	@Column(name = "cmaxspeed")
	private double maxspeed;
	@Column(name = "cnumberofdoors")
	private double numberofdoors;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(double maxspeed) {
		this.maxspeed = maxspeed;
	}
	public double getNumberofdoors() {
		return numberofdoors;
	}
	public void setNumberofdoors(double numberofdoors) {
		this.numberofdoors = numberofdoors;
	}
	
}