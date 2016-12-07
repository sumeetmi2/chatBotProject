/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Nov 30, 2016
 *
 */
package com.doengine.wit.misc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SumeetS
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WitEntity {
    private float confidence;
    private String type;
    private String value;
    private String suggested;
    private WitDateResponseSubObject from;
    private WitDateResponseSubObject to;
    
    /**
     * @return the from
     */
    public WitDateResponseSubObject getFrom() {
        return from;
    }
    /**
     * @param from the from to set
     */
    public void WitDateResponseSubObject(WitDateResponseSubObject from) {
        this.from = from;
    }
    /**
     * @return the to
     */
    public WitDateResponseSubObject getTo() {
        return to;
    }
    /**
     * @param to the to to set
     */
    public void setTo(WitDateResponseSubObject to) {
        this.to = to;
    }
    /**
     * @return the suggested
     */
    public String getSuggested() {
        return suggested;
    }
    /**
     * @param suggested the suggested to set
     */
    public void setSuggested(String suggested) {
        this.suggested = suggested;
    }
    /**
     * @return the confidence
     */
    public float getConfidence() {
        return confidence;
    }
    /**
     * @param confidence the confidence to set
     */
    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
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
}
