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
import com.doengine.talentpool.objects.TalentPoolCriteriaObject;
import com.doengine.talentpool.objects.TalentPoolReportDateCriteria;
import com.doengine.talentpool.objects.TalentPoolReportObject;
import com.doengine.talentpool.objects.TalentPoolReportUserCriteria;
import com.doengine.wit.misc.WitContextObject;
import com.doengine.wit.misc.WitEntity;
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
	WitEntity[] reportTypeEntity = response.getEntities().get("report_type");
	if (reportTypeEntity != null && reportTypeEntity.length > 0) {
	    String intent = commonUtils.getReportTagKeyMap(reportTypeEntity[0].getValue().trim());
	    Class<?> c = this.getClass();
	    Method method = c.getDeclaredMethod(intent, WitResponse.class);
	    method.invoke(this, response);
	}
    }

    public void recruiter_activity_summary(WitResponse response) throws Exception {
	WitEntity intent = response.getEntities().get("intent")[0];
	TalentPoolReportObject reportObject = new TalentPoolReportObject();
	ObjectMapper objectMapper = new ObjectMapper();
	//the report names need to be in upper case
	reportObject.setType(intent.getValue().toUpperCase());
	reportObject.setCriterias(extractDateCriterias(response));
	String jsonBody = objectMapper.writeValueAsString(reportObject);
	//uncomment below url when integrating with talentpool
	//	String response1 = restUtils.postCallTalentPool(environment.getRequiredProperty("talentpool.report.url"), jsonBody);
	String response1 = restUtils.postCallTalentPool(environment.getRequiredProperty("talentpool.report.url"), jsonBody);
	response.setMsg(formResponse(response1, jsonBody, intent.getValue()));
    }

    /**
     * @param response
     * @return
     */
    private List<TalentPoolCriteriaObject> extractDateCriterias(WitResponse response) {
	List<TalentPoolCriteriaObject> criterias = new ArrayList<>();
	WitEntity[] dateTimes = response.getEntities().get("datetime");
	if (dateTimes != null && dateTimes.length > 0) {
	    WitEntity dateTime = dateTimes[0];
	    if ("interval".equals(dateTime.getType())) {
		TalentPoolReportDateCriteria criteria = new TalentPoolReportDateCriteria();
		criteria.setTo(commonUtils.convertWitToTalentPoolReportDateFormat(dateTime.getTo().getValue()));
		criteria.setFrom(commonUtils.convertWitToTalentPoolReportDateFormat(dateTime.getFrom().getValue()));
		criterias.add(criteria);
	    } else if ("value".equals(dateTime.getType())) {
		//set custom interval
	    }
	}
	return criterias;
    }

    public void pending_tasks(WitResponse response) throws Exception {
	WitEntity intent = response.getEntities().get("intent")[0];
	TalentPoolReportObject reportObject = new TalentPoolReportObject();
	ObjectMapper objectMapper = new ObjectMapper();
	//the report names need to be in upper case
	reportObject.setType(intent.getValue().toUpperCase());
	reportObject.setCriterias(createUserCriteria(response));
	String jsonBody = objectMapper.writeValueAsString(reportObject);
	//uncomment below url when hitting talentpool
	//	String response1 = restUtils.postCallTalentPool(environment.getRequiredProperty("talentpool.report.url1"), jsonBody);
	String response1 = restUtils.postCallTalentPool(environment.getRequiredProperty("talentpool.report.url1"), null);
	response.setMsg(formResponse(response1, jsonBody, intent.getValue()));
    }

    private String formResponse(String downloadurl, String criteria, String reportName) {
	StringBuilder sb = new StringBuilder();
	sb.append("Downloadlink: ").append("<a href=\"" + downloadurl + "\">" + downloadurl + "</a>");
	sb.append("<br/>");
	sb.append("ReportName: ").append(reportName);
	sb.append("<br/>");
	sb.append("Criteria: ").append(criteria);
	sb.append("<br/>");
	return sb.toString();
    }

    private List<TalentPoolCriteriaObject> createUserCriteria(WitResponse response) {
	List<TalentPoolCriteriaObject> criterias = new ArrayList<>();
	WitEntity[] ids = response.getEntities().get("number");
	TalentPoolReportUserCriteria userCriteria = new TalentPoolReportUserCriteria();
	if (ids != null && ids.length > 0) {
	    for (WitEntity id : ids) {
		userCriteria.getUsers().add(Integer.parseInt(id.getValue()));
	    }
	    criterias.add(userCriteria);
	}
	return criterias;
    }
}
