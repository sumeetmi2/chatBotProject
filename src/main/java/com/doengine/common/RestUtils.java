/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 1, 2016
 *
 */
package com.doengine.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author SumeetS
 *
 */
@Component
public class RestUtils {
    
    @Autowired
    Environment environment;
    
    public String postCall(String url,String jsonBody){
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	headers.set("Authorization", "Bearer "+ environment.getRequiredProperty("wit.parser.service.auth.key"));
	headers.set("accept", "application/json");
	headers.set("content-type", "application/json");
	HttpEntity<?> httpEntity = new HttpEntity<Object>(jsonBody, headers);
	ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
	return response.getBody();
    }
    
    public String postCallTalentPool(String url,String jsonBody){
	loginToTalentPool();
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	headers.set("content-type", "application/json");
	HttpEntity<?> httpEntity = new HttpEntity<Object>(jsonBody, headers);
	ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
	return response.getBody();
    }
    
    private void loginToTalentPool(){
	String userName= environment.getRequiredProperty("talentpool.userName");
	String password= environment.getRequiredProperty("talentpool.password");
	String rememberMe= environment.getRequiredProperty("talentpool.rememberMe");
	MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
	map.add("userName", userName);
	map.add("password", password);
	map.add("rememberMe",rememberMe);
	RestTemplate rest = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	headers.set("content-type", "application/x-www-form-urlencoded");
	HttpEntity<?> httpEntity = new HttpEntity<Object>(map, headers);
	rest.postForObject(environment.getRequiredProperty("talentpool.login.url"), httpEntity, String.class);
    }
    
}
