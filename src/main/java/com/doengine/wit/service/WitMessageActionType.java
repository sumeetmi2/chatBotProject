/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 2, 2016
 */
package com.doengine.wit.service;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.doengine.common.CommonUtils;
import com.doengine.common.JsonBuilder;
import com.doengine.common.RestUtils;
import com.doengine.common.TalentpoolIntent;
import com.doengine.objects.Bot;
import com.doengine.wit.misc.WitConstants;
import com.doengine.wit.misc.WitResponse;

/**
 * @author SumeetS
 *
 */
@Component
public class WitMessageActionType implements WitActionType {

    @Autowired
    WitIntentServiceInvoker witIntentServiceInvoker;

    @Autowired
    WitResponseParser witResponseParser;

    @Autowired
    JsonBuilder jsonBuilder;

    @Autowired
    Environment environment;

    @Autowired
    RestUtils restUtils;
    
    @Autowired
    CommonUtils commonUtils;

    /*
     * (non-Javadoc)
     * @see com.doengine.parser.WitActionType#implementation(com.doengine.objects.Bot)
     */
    @Override
    public String implementation(Bot bot) throws Exception {
	String url = environment.getRequiredProperty("wit.parser.service.url") + "?v=20160526&q=" + bot.getCurrentChat().getMessage() + "&session_id="
		+ bot.getSessionId();
	String response = restUtils.postCall(url, null);
	WitResponse witResponse = witResponseParser.parse(response);
	if (WitConstants.STOP.equals(witResponse.getType())) {
	    //retry with new session id
	    bot.setSessionId(System.currentTimeMillis());
	    url = environment.getRequiredProperty("wit.parser.service.url") + "?v=20160526&q=" + bot.getCurrentChat().getMessage() + "&session_id="
		    + bot.getSessionId();
	    response = restUtils.postCall(url, null);
	    witResponse = witResponseParser.parse(response);
	}
	EnumSet<TalentpoolIntent> intents = witResponseParser.getIntent(witResponse);
	StringBuilder sb = new StringBuilder();
	if (intents.isEmpty()) {
	    sb.append("Sorry wasnt able to find out what you want to do. Do you want to do something from below?");
	    sb.append("<br/>");
	    for (TalentpoolIntent intent : TalentpoolIntent.values()) {
		String value = intent.toString().toLowerCase();
		sb.append("<a href=\"#\" onclick=\"javascript:feedback('" + value + "')\">" + environment.getRequiredProperty("response." + value)
			+ "</a>");
		sb.append(" ");
		sb.append("<br/>");
	    }
	    //		bot.setActionType(WitConstants.FEEDBACK);
	    bot.setFeedbackExpression(bot.getCurrentChat().getMessage());
	    return sb.toString();
	} else if(!intents.isEmpty() && intents.contains(TalentpoolIntent.REPORT) && !witResponse.getEntities().containsKey("report_type")){
	    sb.append("Were you asking for a report. We have below reports. what would you like to view?");
	    sb.append("<br/>");
	    for(String reportType: commonUtils.getReportTypes()){
		String value = "report&&"+reportType;
		sb.append("<a href=\"#\" onclick=\"javascript:feedback('" + value + "')\">" + reportType
			+ "</a>");
		sb.append(" ");
		sb.append("<br/>");
	    }
	    bot.setFeedbackExpression(bot.getCurrentChat().getMessage());
	    return sb.toString();
	}else {
	    bot.setResponse(response);
	    bot.setActionType(witResponse.getType());
	    String invokerResponse = witIntentServiceInvoker.invokeService(bot, null, null, null);
	    if (invokerResponse != null) {
		return invokerResponse;
	    }
	}
	return witResponse.getMsg();
    }

}
