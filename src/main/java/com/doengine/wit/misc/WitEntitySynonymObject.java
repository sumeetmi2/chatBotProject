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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SumeetS
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class WitEntitySynonymObject {
    
    private Boolean builtin;
    private String doc;
    private Boolean exotic;
    private String id;
    private String lang;
    private String[] lookups = null;
    private String name;
    private WitValueObject[] values = null;
    /**
     * @return the builtin
     */
    public Boolean getBuiltin() {
        return builtin;
    }
    /**
     * @param builtin the builtin to set
     */
    public void setBuiltin(Boolean builtin) {
        this.builtin = builtin;
    }
    /**
     * @return the doc
     */
    public String getDoc() {
        return doc;
    }
    /**
     * @param doc the doc to set
     */
    public void setDoc(String doc) {
        this.doc = doc;
    }
    /**
     * @return the exotic
     */
    public Boolean getExotic() {
        return exotic;
    }
    /**
     * @param exotic the exotic to set
     */
    public void setExotic(Boolean exotic) {
        this.exotic = exotic;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the lang
     */
    public String getLang() {
        return lang;
    }
    /**
     * @param lang the lang to set
     */
    public void setLang(String lang) {
        this.lang = lang;
    }
    /**
     * @return the lookups
     */
    public String[] getLookups() {
        return lookups;
    }
    /**
     * @param lookups the lookups to set
     */
    public void setLookups(String[] lookups) {
        this.lookups = lookups;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the values
     */
    public WitValueObject[] getValues() {
        return values;
    }
    /**
     * @param values the values to set
     */
    public void setValues(WitValueObject[] values) {
        this.values = values;
    }
    
}
