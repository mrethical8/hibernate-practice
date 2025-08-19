package com.telusko.DemoHib;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	private int lid;
	private String lname;
//	@ManyToOne
//	private Student student;//for manytoone
	@ManyToMany
	private List<Student> student = new ArrayList<Student>();
	
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	//for manytoone
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	
	
	//for manytomany
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	
}
