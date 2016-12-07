/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Nov 30, 2016
 *
 */
package com.doengine.common;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SumeetS
 *
 */
@Component
public class JsonBuilder {
    public String jsonUnit(String key,String value){
	JSONObject jsonObj = new JSONObject();
	jsonObj.accumulate(key, value);
	return jsonObj.toString();
    }
    
    public String mapToJsonString(Map<String, String> map) throws JsonProcessingException{
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(map);
    }
}
