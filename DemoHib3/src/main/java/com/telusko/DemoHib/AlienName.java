package com.telusko.DemoHib;

import jakarta.persistence.Embeddable;

//@Entity //it will create a new table
@Embeddable //embeddable annotation to embedd your object inside on another table
public class AlienName {
    //@Id is for primary key so we are not using it and since you are inserting this in a new table so we dont have the existing table so we dont have to that
	private String fname;
	private String lname;
	private String mname;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	} 
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "AlienName [fname=" + fname + ", lname=" + lname + ", mname=" + mname + "]";
	}
	
	
}
