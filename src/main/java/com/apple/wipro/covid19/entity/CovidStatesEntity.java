package com.apple.wipro.covid19.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;



@Entity
@Table(name="covidstate")
public class CovidStatesEntity implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/*@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )*/
	@Id 
	//private UUID id =  UUID.randomUUID();
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name="city")
	private String city;
	
	@Column(name="province")
	private String province;
	
	@Column(name="country")
	private String country;
	
	@Column(name="lastUpdate")
	private Date lastUpdate;
	
	@Column(name="keyId")
	private String keyId;
	
	@Column(name="confirmed")
	private String confirmed;
	
	@Column(name="deaths")
	private String deaths;
	
	@Column(name="recovered")
	private String recovered;
	
	
	public CovidStatesEntity() {
		super();
	}
	public CovidStatesEntity(String city, String province, String country, Date lastUpdate, String keyId, String confirmed,
			String deaths, String recovered) {
		super();
		this.city = city;
		this.province = province;
		this.country = country;
		this.lastUpdate = lastUpdate;
		this.keyId = keyId;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
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
	
	
	/*public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	} */
	
	
	@Override
	public String toString() {
		return "CovidStatesEntity [id=" + id + ", city=" + city + ", province=" + province + ", country=" + country
				+ ", lastUpdate=" + lastUpdate + ", keyId=" + keyId + ", confirmed=" + confirmed + ", deaths=" + deaths
				+ ", recovered=" + recovered + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	                

}
