/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Nov 30, 2016
 */
package com.doengine.wit.service;

import java.io.IOException;
import java.util.EnumSet;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.doengine.common.TalentpoolIntent;
import com.doengine.wit.misc.WitEntity;
import com.doengine.wit.misc.WitResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SumeetS
 *
 */

@Component
public class WitResponseParser {

    protected static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WitResponseParser.class);

    public WitResponse parse(String response) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper objectMapper = new ObjectMapper();
	WitResponse responseObj = objectMapper.readValue(response, WitResponse.class);
	return responseObj;
    }

    public EnumSet<TalentpoolIntent> getIntent(String response) throws Exception {
	WitResponse responseObj = parse(response);
	return getIntentHelper(responseObj);
    }
    
    public EnumSet<TalentpoolIntent> getIntent(WitResponse response){
	return getIntentHelper(response);
    }
    
    private EnumSet<TalentpoolIntent> getIntentHelper(WitResponse responseObj){
	EnumSet<TalentpoolIntent> intents = EnumSet.noneOf(TalentpoolIntent.class);
	if (responseObj.getEntities().get("intent") != null) {
	    for (WitEntity entity : responseObj.getEntities().get("intent")) {
		try {
		    intents.add(TalentpoolIntent.valueOf(entity.getValue().toUpperCase()));
		} catch (IllegalArgumentException e) {
		    LOGGER.error("add intent to enum constants :" + entity.getValue());
		    throw e;
		}
	    }
	}
	return intents;
    }
}
