/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Dec 7, 2016
 *
 */
package com.doengine.dummy.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doengine.controller.BaseController;
import com.doengine.wit.misc.WitReportObject;

/**
 * @author SumeetS
 *
 */
@Controller
@RequestMapping("/dummy")
public class DummyTalentPoolController extends BaseController {
    
    @RequestMapping(value="/1",method=RequestMethod.POST)
    public ResponseEntity<?> getRecruiterActivityReport(@RequestBody WitReportObject witReportObject){
	System.out.println("I AM HERE");
	return new ResponseEntity<>(HttpStatus.OK);
    }
}
