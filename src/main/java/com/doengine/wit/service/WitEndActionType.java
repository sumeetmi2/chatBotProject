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

import org.springframework.stereotype.Component;

import com.doengine.objects.Bot;

/**
 * @author SumeetS
 *
 */
@Component
public class WitEndActionType implements WitActionType{

    /* (non-Javadoc)
     * @see com.doengine.parser.WitActionType#implementation(com.doengine.objects.Bot)
     */
    @Override
    public String implementation(Bot bot) throws Exception {
	 return "Request Complete.Refresh to start a new conversation";
    }

}
