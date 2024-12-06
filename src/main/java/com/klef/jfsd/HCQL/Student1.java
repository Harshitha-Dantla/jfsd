package com.klef.jfsd.HCQL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HCQL_table")
public class Student1 
{
	@Id
	@Column(name = "sid")
	private int id;
	@Column(name="sname",length = 50,nullable = false)
	private String name;
	@Column(name="sgender",length = 10,nullable = false)
	private String gender;
	@Column(name="sdepartment",length = 30,nullable = false)
	private String department;
	@Column(name="sfee",nullable = false)
	private double fee;
	@Column(name="scontactno",length = 20,nullable = false,unique = true)
	private String contactno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
}