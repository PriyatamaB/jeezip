package com.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class DataServiceImpl implements DataService {

	@Override
	public List<String> getCities() {
		// TODO Auto-generated method stub
		return Arrays.asList("Pune","Mumbai","Delhi");
		
	}

	@Override
	public List<Double> getAmounts() {
		// TODO Auto-generated method stub
		return Arrays.asList(500d,1000d,1500d,2000d);
	}

}
