package com.qa.API.base;

import org.apache.log4j.Logger;

import com.qa.API.tests.TC001_GET_All_Employees;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public RequestSpecification httpRequest;
	public Response response;

	public static Logger logger;

	
	
	
	
	public static void setUp() {
		logger = Logger.getLogger(TestBase.class);
		/*
		 * logger = Logger.getLogger("getAllEmployees");
		 * PropertyConfigurator.configure("Log4j.properties");
		 * logger.setLevel(Level.DEBUG);
		 */
	}

}
