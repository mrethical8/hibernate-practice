package com.telusko.DemoHib;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity//(name="Employee") //it is entity name to change it
@Table (name="Employee_table") // table name
public class Alien { //POJO //it is defualt name
	@Id
	private int aid;
	//@Transient // temporary data is not getting store of latest one which u added as aname
	private String aname;
	@Column(name="Employee_color")//u can specify the column name
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
	
}
