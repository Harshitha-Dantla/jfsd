package com.klef.jfsd.HQL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "stu_name",length = 30,nullable = false)
	private String name;
	@Column(name = "stu_department",length = 30,nullable = false)
	private String department;
	@Column(name = "stu_fee",length = 10,nullable = false)
	private double fee;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String department, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.fee = fee;
	}
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", fee=" + fee + "]";
	}
	
	
}