package com.apple.wipro.covid19.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="covidtotal")
public class CovidTotalEntity implements Serializable {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	//UUID.randomUUID()
	private int id;
	
	@Column(name="confirmed")
	private String confirmed;
	
	@Column(name="deaths")
	private String deaths;
	
	@Column(name="recovered")
	private String recovered;
	
	@Column(name="lastChecked")
	private String lastChecked;
	
	@Column(name="lastReported")
	private String lastReported;
	
	@Column(name="location")
	private String location;
	
	
	public CovidTotalEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CovidTotalEntity(String confirmed, String deaths, String recovered, String lastChecked, String lastReported,
			String location) {
		super();
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
		this.lastChecked = lastChecked;
		this.lastReported = lastReported;
		this.location = location;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public String getLastChecked() {
		return lastChecked;
	}
	public void setLastChecked(String lastChecked) {
		this.lastChecked = lastChecked;
	}
	public String getLastReported() {
		return lastReported;
	}
	public void setLastReported(String lastReported) {
		this.lastReported = lastReported;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "CovidTotal [confirmed=" + confirmed + ", deaths=" + deaths + ", recovered=" + recovered
				+ ", lastChecked=" + lastChecked + ", lastReported=" + lastReported + ", location=" + location + "]";
	}
	
	

}
