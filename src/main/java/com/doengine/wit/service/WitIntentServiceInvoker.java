/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 6, 2016
 */
package com.doengine.wit.service;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doengine.common.JsonBuilder;
import com.doengine.common.RestUtils;
import com.doengine.common.TalentpoolIntent;
import com.doengine.objects.Bot;
import com.doengine.wit.misc.WitContextObject;
import com.doengine.wit.misc.WitResponse;

/**
 * @author SumeetS
 *
 */
@Component
public class WitIntentServiceInvoker {
    @Autowired
    WitIntentBasedServiceFactory witIntentBasedServiceFactory;

    @Autowired
    RestUtils restUtils;

    @Autowired
    JsonBuilder jsonBuilder;

    @Autowired
    WitResponseParser witResponseParser;

    /**
     * @param intent
     * @param contextObject
     * @param inputWitResponse
     *        for processing the response
     * @param service
     *        url to be hit to update the outputwitresponse object if service url is null then bot object remains unchanged
     * @param outputWitResponse
     *        in case of action call update this object with new response. Send a non null object for hitting witservice
     * @throws Exception
     */
    public String invokeService(Bot bot, WitContextObject contextObject, String serviceUrl, WitResponse outputWitResponse) throws Exception {
	WitResponse witResponse = witResponseParser.parse(bot.getResponse());
	EnumSet<TalentpoolIntent> intents = witResponseParser.getIntent(witResponse);
	TalentpoolIntent intent = intents.iterator().next();
	WitIntentService witIntentService = witIntentBasedServiceFactory.getService(intent.toString());
	if (witIntentService instanceof WitPerformActionIntentService) {
	    witIntentService = (WitPerformActionIntentService) witIntentService;
	    ((WitPerformActionIntentService) witIntentService).performAction(witResponse);
	}
	WitContextObject tmp = null;
	tmp = witIntentService.updateContext(witResponse);
	if (tmp != null) {
	    contextObject = tmp;
	}
	if (serviceUrl != null && serviceUrl.length() > 0) {
	    String response = null;
	    if (contextObject != null && contextObject.getContextMap().size() > 0) {
		response = restUtils.postCall(serviceUrl, jsonBuilder.mapToJsonString(contextObject.getContextMap()));
	    } else {
		response = restUtils.postCall(serviceUrl, null);
	    }
	    bot.setResponse(response);
	    outputWitResponse = witResponseParser.parse(response);
	    bot.setActionType(outputWitResponse.getType());
	    return outputWitResponse.getMsg();
	}
	return null;
    }
}
