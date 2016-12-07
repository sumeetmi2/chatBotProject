/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 5, 2016
 *
 */
package com.doengine.wit.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SumeetS
 *
 */
public class WitFeedbackObject {
    private String value;
    private List<String> expressions = new ArrayList<>();
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
    public List<String> getExpressions() {
        return new ArrayList<>(expressions);
    }
    /**
     * @param expressions the expressions to set
     */
    public void setExpressions(List<String> expressions) {
        this.expressions.addAll(expressions);
    }
    
    
}
