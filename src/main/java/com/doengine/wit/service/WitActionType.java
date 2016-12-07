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

import com.doengine.objects.Bot;

/**
 * @author SumeetS
 *
 */
public interface WitActionType {
    public String implementation(Bot bot) throws Exception;
}
