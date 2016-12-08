/*
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved.
 * This software is the proprietary information of Talentica Software (India) Private Limited.
 * Use is subject to license terms. *
 * Created on Dec 7, 2016
 */
package com.doengine.dummy.service;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doengine.controller.BaseController;

/**
 * @author SumeetS
 *
 */
@Controller
@RequestMapping("/dummy")
public class DummyTalentPoolController extends BaseController {

    @RequestMapping(value = "/1", method = RequestMethod.POST)
    public ResponseEntity<?> getRecruiterActivityReport() {
	String url = "http://localhost:8080/DoEngine/dummy/download1";
	return new ResponseEntity<>(url,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/2", method = RequestMethod.POST)
    public ResponseEntity<?> getPendingActionReport() {
	String url = "http://localhost:8080/DoEngine/dummy/download2";
	return new ResponseEntity<>(url,HttpStatus.OK);
    }

    @RequestMapping(value = "/download1", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public HttpEntity<?> downloadFile1(HttpServletResponse response) {
	try {
	    byte[] bytes = FileCopyUtils.copyToByteArray(new File("D:/Dummy1.xls"));
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    response.setHeader("Content-Disposition", "attachment; filename=Dummy1.xls");
	    return new HttpEntity<byte[]>(bytes, headers);
	} catch (Exception e) {
	    LOGGER.error(e.getMessage());
	}
	return null;
    }
    
    @RequestMapping(value = "/download2", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public HttpEntity<?> downloadFile2(HttpServletResponse response) {
	try {
	    byte[] bytes = FileCopyUtils.copyToByteArray(new File("D:/Dummy2.xlsx"));
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    response.setHeader("Content-Disposition", "attachment; filename=Dummy2.xlsx");
	    return new HttpEntity<byte[]>(bytes, headers);
	} catch (Exception e) {
	    LOGGER.error(e.getMessage());
	}
	return null;
    }
}
