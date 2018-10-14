package com.manifesto.userlocation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLocation {
	
	@Id
	private int id;
	private double latitude;
	private double longitude;
	
	public UserLocation(int id, double latitude, double longitude) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public UserLocation() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
