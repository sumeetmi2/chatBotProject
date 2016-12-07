/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 2, 2016
 *
 */
package com.doengine.wit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doengine.wit.misc.WitConstants;

/**
 * @author SumeetS
 *
 */
@Component
public class WitActionBasedServiceFactory {
    
    @Autowired
    WitActionType witMessageActionType;
    
    @Autowired
    WitActionType witEndActionType;
    
    @Autowired
    WitActionType witActionActionType;
    
    @Autowired
    WitActionType witFeedbackActionType;
    
    public WitActionType getActionService(String actionType){
	switch(actionType){
	    case WitConstants.MSG: return witMessageActionType;
	    case WitConstants.ACTION: return witActionActionType;
	    case WitConstants.END: return witEndActionType;
	    case WitConstants.FEEDBACK: return witFeedbackActionType; 
	    case WitConstants.MERGE: break;
	}
	return null;
    }
}
