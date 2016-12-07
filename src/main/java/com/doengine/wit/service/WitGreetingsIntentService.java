/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 1, 2016
 */
package com.doengine.wit.service;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doengine.common.JsonBuilder;
import com.doengine.wit.misc.WitContextObject;
import com.doengine.wit.misc.WitResponse;

/**
 * @author SumeetS
 * 
 *         implement the actions defined under wit console and implement code to update context
 *
 */
@Service(value = "witGreetingsIntentService")
public class WitGreetingsIntentService implements WitIntentService {

    @Autowired
    JsonBuilder jsonBuilder;

    /*
     * (non-Javadoc)
     * @see com.doengine.parser.WitIntentService#updateContext(com.doengine.parser.WitResponse)
     */
    @Override
    public WitContextObject updateContext(WitResponse response) throws Exception {
	WitContextObject contextObj = new WitContextObject();
	Class<?> c = this.getClass();
	Method method = c.getDeclaredMethod(response.getAction(), WitResponse.class, WitContextObject.class);
	method.invoke(this, response, contextObj);
	return contextObj;
    }

    /**
     * @param response
     * @param contextObj
     * 
     *        implemented in wit ai console
     */
    private void greetingsHuman(WitResponse response, WitContextObject contextObj) {
	if (response.getEntities().size() > 0 && response.getEntities().get("contact") !=null) {
	    String contact = response.getEntities().get("contact")[0].getValue();
	    if(contact!=null){
		contextObj.addToContext("name", contact);
	    }
	}else {
	    contextObj.addToContext("missingName", "true");
	    
	}
    }

}
