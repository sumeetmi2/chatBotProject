package com.doengine.controller;

/*
 *  
 * Created on Oct 16, 2016
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.doengine.objects.ResponseWrapperObject;


/**
 * @author SumeetS
 *
 */
public class BaseController {


    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    protected <T> ResponseEntity<ResponseWrapperObject<T>> sendSuccessResponse(ResponseWrapperObject<T> responseObj, HttpStatus httpStatus) {
	return new ResponseEntity<ResponseWrapperObject<T>>(responseObj, httpStatus);
    }

    protected <T> ResponseEntity<ResponseWrapperObject<T>> sendErrorResponse(ResponseWrapperObject<T> responseObj, HttpStatus httpStatus) {
	return new ResponseEntity<ResponseWrapperObject<T>>(responseObj, httpStatus);
    }
    
}
