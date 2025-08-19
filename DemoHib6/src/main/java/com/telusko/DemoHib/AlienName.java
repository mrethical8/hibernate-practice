package com.telusko.DemoHib;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Alien_table")
public class AlienName{
    //@Id 
	private int aid;
	private String aname;
	private String color;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "AlienName [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	

	
	
}
