/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 5, 2016
 */
package com.doengine.wit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.doengine.common.RestUtils;
import com.doengine.objects.Bot;
import com.doengine.objects.Chat;
import com.doengine.wit.misc.WitConstants;
import com.doengine.wit.misc.WitFeedbackObject;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author SumeetS
 *
 */
@Service
public class WitFeedbackActionType implements WitActionType {

    @Autowired
    RestUtils restUtils;

    @Autowired
    Environment environment;

    /*
     * (non-Javadoc)
     * @see com.doengine.parser.WitActionType#implementation(com.doengine.objects.Bot)
     */
    @Override
    public String implementation(Bot bot) throws Exception {
	String url = environment.getRequiredProperty("wit.feedback.entity.update");
	ArrayList<String> feedbackExpressions = new ArrayList<String>();
	feedbackExpressions.add(bot.getFeedbackExpression());
	WitFeedbackObject feedbackObject = new WitFeedbackObject();
	String intent = bot.getFeedbackIntent();
	String body = null;
	if (intent.contains("&&")) {
	    String[] tmp = intent.split("&&");
	    if(tmp[0].equalsIgnoreCase("report")){
		intent = tmp[1];
		url = environment.getRequiredProperty("wit.feedback.report_type.update");
		url = url.replaceAll("\\{entity-value\\}", intent);
		body = "{\"expression\":\""+bot.getFeedbackExpression()+"\"}";
	    }
	}else{
	    feedbackObject.setValue(intent);
	    feedbackObject.setExpressions(feedbackExpressions);
	    ObjectMapper mapper = new ObjectMapper();
	    body = mapper.writeValueAsString(feedbackObject);
	}
	restUtils.postCall(url, body);
	bot.setActionType(WitConstants.FEEDBACK);
	Chat currentChat = new Chat();
	currentChat.setMessage(bot.getFeedbackExpression());
	bot.setCurrentChat(currentChat);
	return "ok i understood it now. try again..";
    }

}
