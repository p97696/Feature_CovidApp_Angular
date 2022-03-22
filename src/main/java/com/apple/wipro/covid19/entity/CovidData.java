package com.apple.wipro.covid19.entity;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;



@Component
public class CovidData {

	
	private Date lastChecked;
	
	//private CovidStates[] covid19Stats;
	
	private CovidStatesEntity[] covid19Stats;

	public Date getLastChecked() {
		return lastChecked;
	}

	public void setLastChecked(Date lastChecked) {
		this.lastChecked = lastChecked;
	}

	public CovidStatesEntity[] getCovid19Stats() {
		return covid19Stats;
	}

	public void setCovid19Stats(CovidStatesEntity[] covid19Stats) {
		this.covid19Stats = covid19Stats;
	}

	@Override
	public String toString() {
		return "CovidData [lastChecked=" + lastChecked + ", covid19Stats=" + Arrays.toString(covid19Stats) + "]";
	}

	
		
	
	
	
		
	
}
