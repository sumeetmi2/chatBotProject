/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 7, 2016
 */
package com.doengine.wit.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SumeetS
 *
 */
public class WitReportObject {
    private String type;
    private List<WitReportCriteria> criterias = new ArrayList<>();

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
     * @return the criterias
     */
    public List<WitReportCriteria> getCriterias() {
	return criterias;
    }

    /**
     * @param criterias
     *        the criterias to set
     */
    public void setCriterias(List<WitReportCriteria> criterias) {
	this.criterias = criterias;
    }
}
