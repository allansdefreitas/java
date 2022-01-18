package br.edu.allan.model;

import java.io.Serializable;

public class Event implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String organizationName;
	private String place;
	private String date;
	private String time;
	
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	@Override
	public String toString() {
		return "Event [name=" + name + ", organizationName=" + organizationName + ", place=" + place + ", date=" + date
				+ ", time=" + time + "]";
	}
	
	
	
	
}
