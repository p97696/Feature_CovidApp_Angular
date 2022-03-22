package com.apple;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.apple.wipro.covid19.entity.CovidBean;
import com.apple.wipro.covid19.entity.CovidStatesEntity;
import com.apple.wipro.covid19.entity.CovidTotal;
import com.apple.wipro.covid19.entity.CovidTotalBean;
import com.apple.wipro.covid19.entity.CovidTotalEntity;
import com.apple.wipro.covid19.repository.CovidRepository;
import com.apple.wipro.covid19.repository.CovidStatesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.apple.wipro.covid19.repository")
//@ComponentScan(basePackages= "com.apple.wipro.covid19.controller")
//@EntityScan(basePackages = "com.apple.wipro.covid19.entity")
public class CovidDemoApplication {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(CovidDemoApplication.class, args);
	}
}
	
	

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CovidRepository covidRepository;
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private CovidStatesRepository covidStatesRepository;
	

	@Override
	public void run(String... args) throws Exception {

		
		String url="https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total";
		
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url);
		URI uri = uriComponentsBuilder.build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
		headers.set("x-rapidapi-key", "fea7cfe218mshde1614cbd8bdb80p1c6672jsne29648ecadd1");
		//headers.set("Country", "Canada");
		HttpEntity<String> entity = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(uri,HttpMethod.GET,entity,String.class);
		CovidTotal covidTotal = null;
		try {
			ObjectMapper om=new ObjectMapper();
			covidTotal = om.readValue(response.getBody(), CovidTotal.class);
			//System.out.println("String value:::"+covidTotal.toString());
			//CovidTotalEntity totalEntity = covidTotal.getData();
		
		//System.out.println("Response getBody length:::"+covidBean.getData().getCovid19Stats().length);
		}catch(Exception ex) {
			ex.printStackTrace();
		} 
		
		//System.out.println("CovidTotal:::"+covidTotal.getData());
		

		covidRepository.save(covidTotal.getData());
		
		/***************************************************/
		
		url="https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";		
		
		uriComponentsBuilder = UriComponentsBuilder.fromUriString(url);
		uri = uriComponentsBuilder.build().toUri();
		System.out.println("State URL:::"+url.toString());
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
		headers.set("x-rapidapi-key", "fea7cfe218mshde1614cbd8bdb80p1c6672jsne29648ecadd1");
		//headers.set("Country", "Canada");
		
		
		entity = new HttpEntity(headers);
		
		//HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		
		//workingResponseEntity<String> response = restTemplate.exchange(uri,HttpMethod.GET,entity,String.class);
		ResponseEntity<String> response1 = restTemplate.exchange(uri,HttpMethod.GET,entity,String.class);
		//JSONObject json = new JSONObject(response.getBody());
		CovidBean covidBean= null;
		try {
			ObjectMapper om=new ObjectMapper();
			covidBean = om.readValue(response1.getBody(), CovidBean.class);
			System.out.println("Response getBody length:::"+covidBean.getData().getCovid19Stats().length);

			List<CovidStatesEntity> l1 = Arrays.asList(covidBean.getData().getCovid19Stats());
			l1.forEach(a -> System.out.println(a.toString()));
			//l1.forEach(a -> covidStatesRepository.save(a));
			
			covidStatesRepository.saveAll(l1);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		}
}

