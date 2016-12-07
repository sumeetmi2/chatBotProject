/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 1, 2016
 */
package com.doengine.wit.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.doengine.common.CommonUtils;
import com.doengine.common.RestUtils;
import com.doengine.wit.misc.WitContextObject;
import com.doengine.wit.misc.WitEntity;
import com.doengine.wit.misc.WitReportCriteria;
import com.doengine.wit.misc.WitReportObject;
import com.doengine.wit.misc.WitResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SumeetS
 *
 */
@Service(value = "witReportIntentService")
public class WitReportIntentService implements WitPerformActionIntentService {

    @Autowired
    RestUtils restUtils;

    @Autowired
    Environment environment;

    @Autowired
    CommonUtils commonUtils;

    /*
     * (non-Javadoc)
     * @see com.doengine.parser.WitIntentService#updateContext(com.doengine.parser.WitResponse)
     */
    @Override
    public WitContextObject updateContext(WitResponse response) throws Exception {
	return null;
    }

    /*
     * (non-Javadoc)
     * @see com.doengine.wit.service.WitPerformActionIntentService#performAction(com.doengine.wit.misc.WitResponse)
     */
    @Override
    public void performAction(WitResponse response) throws Exception {
	WitEntity intentEntity = response.getEntities().get("intent")[0];
	String intent = intentEntity.getValue();
	Class<?> c = this.getClass();
	Method method = c.getDeclaredMethod(intent, WitResponse.class);
	method.invoke(this, response);
    }

    public void recruiter_activity_summary(WitResponse response) throws Exception {
	WitEntity intent = response.getEntities().get("intent")[0];
	WitReportObject reportObject = new WitReportObject();
	ObjectMapper objectMapper = new ObjectMapper();
	//the report names need to be in upper case
	reportObject.setType(intent.getValue().toUpperCase());
	reportObject.setCriterias(extractCriterias(response));
	String jsonBody = objectMapper.writeValueAsString(reportObject);
	String response1 = restUtils.postCallTalentPool(environment.getRequiredProperty("talentpool.report.url"), jsonBody);
	System.out.println(response1);
    }

    /**
     * @param response
     * @return
     */
    private List<WitReportCriteria> extractCriterias(WitResponse response) {
	List<WitReportCriteria> criterias = new ArrayList<>();
	WitEntity[] dateTimes = response.getEntities().get("datetime");
	if (dateTimes!=null && dateTimes.length > 0) {
	    WitEntity dateTime = dateTimes[0];
	    if ("interval".equals(dateTime.getType())) {
		WitReportCriteria criteria = new WitReportCriteria();
		criteria.setTo(commonUtils.convertWitToTalentPoolReportDateFormat(dateTime.getTo().getValue()));
		criteria.setFrom(commonUtils.convertWitToTalentPoolReportDateFormat(dateTime.getFrom().getValue()));
		criteria.setType("dateCriteria");
		criterias.add(criteria);
	    } else if ("value".equals(dateTime.getType())) {
		//set custom interval
	    }
	}
	return criterias;
    }

    public void pending_task(WitResponse response) {

    }

}
