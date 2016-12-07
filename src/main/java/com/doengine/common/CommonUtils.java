/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 6, 2016
 *
 */
package com.doengine.common;

import org.springframework.stereotype.Component;

/**
 * @author SumeetS
 *
 */
@Component
public class CommonUtils {
    public String convertWitToTalentPoolReportDateFormat(String dateString){
	String tmp = dateString.substring(0,10);
	return tmp;
    }
}
