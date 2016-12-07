/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 2, 2016
 */
package com.doengine.wit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.doengine.objects.Bot;

/**
 * @author SumeetS
 *
 */
@Component
public class WitActionActionType implements WitActionType {

    @Autowired
    WitIntentServiceInvoker witIntentServiceInvoker;

    @Autowired
    Environment environment;

    /*
     * (non-Javadoc)
     * @see com.doengine.parser.WitActionType#implementation(com.doengine.objects.Bot)
     */
    @Override
    public String implementation(Bot bot) throws Exception {
	String url = environment.getRequiredProperty("wit.parser.service.url") + "?v=20160526&session_id=" + bot.getSessionId();
	return witIntentServiceInvoker.invokeService(bot, null, url, null);
    }

}
