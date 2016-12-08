/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 6, 2016
 */
package com.doengine.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.doengine.wit.misc.WitEntitySynonymObject;
import com.doengine.wit.misc.WitValueObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SumeetS
 *
 */
@Component
public class CommonUtils {

    private Map<String, String> reportTagKeyMap = new HashMap<>();
    private List<String> reportTypes = new ArrayList<>();

    @Autowired
    RestUtils restUtils;

    @Autowired
    Environment environment;

    @PostConstruct
    public void initReportTagKeyMap() {
	reportTagKeyMap.put("recruiter activity summary", "recruiter_activity_summary");
	reportTagKeyMap.put("pending tasks", "pending_tasks");
    }

    public String convertWitToTalentPoolReportDateFormat(String dateString) {
	String tmp = dateString.substring(0, 10);
	return tmp;
    }

    public String getReportTagKeyMap(String tagName) {
	return reportTagKeyMap.get(tagName);
    }

    public List<String> getReportTypes() throws JsonParseException, JsonMappingException, IOException {
	if (reportTypes.isEmpty()) {
	    String response = restUtils.getCall(environment.getRequiredProperty("wit.report_type.synonym.get"), null);
	    ObjectMapper objectMapper = new ObjectMapper();
	    WitEntitySynonymObject responseObj = objectMapper.readValue(response, WitEntitySynonymObject.class);
	    for(WitValueObject value: responseObj.getValues()){
		reportTypes.add(value.getValue());
	    }
	}
	return reportTypes;
    }

}
