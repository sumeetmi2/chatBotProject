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

import com.doengine.wit.misc.WitContextObject;
import com.doengine.wit.misc.WitResponse;

/**
 * @author SumeetS
 *
 */
public interface WitIntentService {
    
    public WitContextObject updateContext(WitResponse response) throws Exception;
}
