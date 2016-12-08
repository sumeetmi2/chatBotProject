/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 7, 2016
 *
 */
package com.doengine.talentpool.objects;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author SumeetS
 *
 */
public class TalentPoolReportUserCriteria extends TalentPoolCriteriaObject {
    private List<Integer> users = new ArrayList<Integer>();
    @JsonProperty("@type")
    private String type = "pendingTaskUserCriteria";

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
     * @return the users
     */
    public List<Integer> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<Integer> users) {
        this.users = users;
    }
    
    
}
