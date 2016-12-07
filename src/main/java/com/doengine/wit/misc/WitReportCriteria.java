/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 7, 2016
 */
package com.doengine.wit.misc;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author SumeetS
 *
 */
public class WitReportCriteria {
    @JsonProperty("@type")
    private String type;
    private String from;
    private String to;

    /**
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *        the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the from
     */
    public String getFrom() {
	return from;
    }

    /**
     * @param from
     *        the from to set
     */
    public void setFrom(String from) {
	this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
	return to;
    }

    /**
     * @param to
     *        the to to set
     */
    public void setTo(String to) {
	this.to = to;
    }

}
