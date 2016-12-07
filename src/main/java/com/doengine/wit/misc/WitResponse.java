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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SumeetS
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WitResponse {
    private float confidence;
    private String type;
    private String msg;
    private Map<String, WitEntity[]> entities;
    private String msg_id;
    private String _text;
    private String action;
    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }
    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }
    /**
     * @return the msg_id
     */
    public String getMsg_id() {
        return msg_id;
    }
    /**
     * @param msg_id the msg_id to set
     */
    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }
    /**
     * @return the _text
     */
    public String get_text() {
        return _text;
    }
    /**
     * @param _text the _text to set
     */
    public void set_text(String _text) {
        this._text = _text;
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
     * @return the entities
     */
    public Map<String, WitEntity[]> getEntities() {
        return entities;
    }
    /**
     * @param entities the entities to set
     */
    public void setEntities(Map<String, WitEntity[]> entities) {
        this.entities = entities;
    }
}
