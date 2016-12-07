/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Nov 30, 2016
 *
 */
package com.doengine.common;

import java.util.Arrays;
import java.util.List;

/**
 * @author SumeetS
 *
 */
public enum TalentpoolIntent {
    REPORT("recruiter_activity_summary","pending_task"),CANDIDATE("candidate"),APPOINTMENT("appointment"),GREETING("greeting");
    
    
    private List<String> values;
    /**
     * 
     */
    private TalentpoolIntent(String ...values) {
	this.values = Arrays.asList(values);
    }
    
    public List<String> getValues(){
	return values;
    }
    
    public static TalentpoolIntent find(String key){
	for(TalentpoolIntent intent: TalentpoolIntent.values()){
	    if(intent.values.contains(key)){
		return intent;
	    }
	}
	return null;
    }
    
    
    
}
