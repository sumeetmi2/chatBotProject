/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Nov 4, 2016
 *
 */
package com.doengine.services;

import com.doengine.objects.Bot;

/**
 * @author SumeetS
 *
 */
public interface BotService {
    public String parse(Bot bot) throws Exception;
}
