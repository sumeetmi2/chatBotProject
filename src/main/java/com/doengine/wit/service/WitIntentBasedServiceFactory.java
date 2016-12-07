/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 1, 2016
 *
 */
package com.doengine.wit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doengine.common.TalentpoolIntent;

/**
 * @author SumeetS
 *
 */
@Component
public class WitIntentBasedServiceFactory {
    
    @Autowired
    WitIntentService witGreetingsIntentService;
    
    @Autowired
    WitIntentService witReportIntentService;
    
    public WitIntentService getService(String intent){
	switch(TalentpoolIntent.valueOf(intent.toUpperCase())){
	    case GREETING: return witGreetingsIntentService;
	    case REPORT: return witReportIntentService;
	    case APPOINTMENT:
		break;
	    case CANDIDATE:
		break;
	    default:
		break;
	}
	return null;
    }
}
