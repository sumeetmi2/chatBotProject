/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 8, 2016
 *
 */
package com.doengine.wit.misc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SumeetS
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class WitValueObject {
    private String value;
    private String[] expressions;
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    /**
     * @return the expressions
     */
    public String[] getExpressions() {
        return expressions;
    }
    /**
     * @param expressions the expressions to set
     */
    public void setExpressions(String[] expressions) {
        this.expressions = expressions;
    }
    
    
}
