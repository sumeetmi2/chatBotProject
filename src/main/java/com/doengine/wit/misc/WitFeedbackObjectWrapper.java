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
public class WitFeedbackObjectWrapper {
    private List<WitFeedbackObject> values = new ArrayList<>();

    /**
     * @return the values
     */
    public List<WitFeedbackObject> getValues() {
        return new ArrayList<>(values);
    }

    /**
     * @param values the values to set
     */
    public void setValues(List<WitFeedbackObject> values) {
        this.values.addAll(values);
    }
    
    
}
