package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name = "scholar_table")

//@DiscriminatorValue("SCHOLAR")

public class Truck extends Vehical
{
	@Column(name = "tname",length = 50)
	private String name;
	@Column(name = "ttype",length = 50)
	private String type;
	@Column(name = "tloadcapacity")
	private double loadcapacity;
	@Column(name = "tmaxspeed")
	private double maxspeed;
	@Column(name = "tcolor",length = 40)
	private String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLoadcapacity() {
		return loadcapacity;
	}
	public void setLoadcapacity(double loadcapacity) {
		this.loadcapacity = loadcapacity;
	}
	public double getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(double maxspeed) {
		this.maxspeed = maxspeed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}