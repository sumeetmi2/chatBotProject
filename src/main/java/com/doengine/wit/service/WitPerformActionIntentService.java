/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 6, 2016
 *
 */
package com.doengine.wit.service;

import com.doengine.wit.misc.WitResponse;

/**
 * @author SumeetS
 *
 */
public interface WitPerformActionIntentService extends WitIntentService{
    public void performAction(WitResponse response) throws Exception;
}
