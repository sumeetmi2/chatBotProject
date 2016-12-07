/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 1, 2016
 *
 */
package com.doengine.wit.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SumeetS
 *
 */
public class WitContextObject {
    private Map<String, String> context = new HashMap<String, String>();

    public Map<String,String> getContextMap(){
	return context;
    }
    
    public void addToContext(String key, String value){
	context.put(key, value);
    }
}
