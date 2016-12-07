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

import com.doengine.common.JsonBuilder;
import com.doengine.common.RestUtils;
import com.doengine.common.TalentpoolIntent;
import com.doengine.objects.Bot;
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

	EnumSet<TalentpoolIntent> intents = witResponseParser.getIntent(witResponse);
	StringBuilder sb = new StringBuilder();
	if (intents.isEmpty()) {
	    sb.append("Sorry wasnt able to find out what you want to do. Do you want to do something from below?");
	    sb.append("\n");
	    for (TalentpoolIntent intent : TalentpoolIntent.values()) {
		for (String value : intent.getValues()) {
		    sb.append("<a href=\"#\" onclick=\"javascript:feedback('" + value + "')\">"
			    + environment.getRequiredProperty("response." + value) + "</a>");
		    sb.append(" ");
		    sb.append("<br/>");
		}
	    }
	    //		bot.setActionType(WitConstants.FEEDBACK);
	    bot.setFeedbackExpression(bot.getCurrentChat().getMessage());
	    return sb.toString();
	} else {
	    bot.setResponse(response);
	    bot.setActionType(witResponse.getType());
	    witIntentServiceInvoker.invokeService(bot, null, null, null);
	}
	return witResponse.getMsg();
    }

}
