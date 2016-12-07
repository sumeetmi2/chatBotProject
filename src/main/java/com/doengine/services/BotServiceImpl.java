/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Nov 4, 2016
 */
package com.doengine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.doengine.common.CommonConstants;
import com.doengine.common.RestUtils;
import com.doengine.objects.Bot;
import com.doengine.wit.misc.WitConstants;
import com.doengine.wit.service.WitActionBasedServiceFactory;
import com.doengine.wit.service.WitActionType;
import com.doengine.wit.service.WitResponseParser;

/**
 * @author SumeetS
 *
 */
@Service
public class BotServiceImpl implements BotService {

    @Autowired
    Environment environment;

    @Autowired
    WitResponseParser witResponseParser;

    @Autowired
    RestUtils restUtils;

    @Autowired
    WitActionBasedServiceFactory witActionBasedServiceFactory;

    /*
     * (non-Javadoc)
     * @see com.doengine.services.BotService#parse(com.doengine.objects.Bot)
     */
    @Override
    public String parse(Bot bot) throws Exception {
	WitActionType actionType = null;
	if (CommonConstants.BOT_CONVERSATION_INIT_FLAG.equals(bot.getResponse())) {
	    actionType = witActionBasedServiceFactory.getActionService(WitConstants.MSG);
	} else {
	    actionType = witActionBasedServiceFactory.getActionService(bot.getActionType());
	}
	StringBuilder sb = new StringBuilder();
	sb.append(actionType.implementation(bot));
	return sb.toString();
    }

    //separate first query

}
