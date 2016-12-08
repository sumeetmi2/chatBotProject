/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 7, 2016
 */
package com.doengine.talentpool.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SumeetS
 *
 */
public class TalentPoolReportObject {
    private String type;
    private List<TalentPoolCriteriaObject> criterias = new ArrayList<>();

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
    public List<TalentPoolCriteriaObject> getCriterias() {
	return criterias;
    }

    /**
     * @param criterias
     *        the criterias to set
     */
    public void setCriterias(List<TalentPoolCriteriaObject> criterias) {
	this.criterias = criterias;
    }
}
