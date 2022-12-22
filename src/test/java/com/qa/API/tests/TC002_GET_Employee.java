package com.qa.API.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.API.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GET_Employee extends TestBase {

	@BeforeClass
	public void getAllEmployee() throws InterruptedException {
		logger = Logger.getLogger(TestBase.class);
		logger.info("-------------Started TC002_GET_Employee-------------");

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/1");

		Thread.sleep(2000);

	}

	@Test
	public void vldResponseBody() {

		logger.info("-------------Started vldResponseBody-------------");

		String responseBody = response.getBody().asString();
		logger.info("ResponseBody is: " + responseBody);
		Assert.assertTrue(responseBody != null);

		logger.info("-------------Ended vldResponseBody-------------");

	}

	@Test
	public void vldStatusCode() {

		logger.info("-------------Started vldStatusCode-------------");

		int statusCode = response.getStatusCode();
		logger.info("StatusCode is: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		logger.info("-------------Ended vldStatusCode-------------");

	}

	@Test
	public void vldStatusLine() {

		logger.info("-------------Started vldStatusLine-------------");

		String statusLine = response.getStatusLine();
		logger.info("statusLine is: " + statusLine);

		logger.info("-------------Ended vldStatusLine-------------");

	}

	@Test
	public void vldResponseTime() {

		logger.info("-------------Started vldResponseTime-------------");

		long responseTime = response.getTime();

		if (responseTime > 100) {
			logger.info("ResponseTime is: " + responseTime);
		}

		Assert.assertTrue(responseTime > 100);
		logger.info("-------------Ended vldResponseTime-------------");

	}

	@Test
	public void vldContentType() {

		logger.info("-------------Started vldContentType-------------");

		String contentType = response.header("Content-Type");
		logger.info("ContentType is: " + contentType);

		logger.info("-------------Ended vldContentType-------------");

	}

	@Test
	public void vldServerType() {

		logger.info("-------------Started vldServerType-------------");

		String serverType = response.header("Server");
		logger.info("ServerType is: " + serverType);

		logger.info("-------------Ended vldServerType-------------");

	}

	@Test
	public void vldContentLength() {
		logger.info("-------------Started vldContentLength-------------");
		String contentLength = response.header("Content-Length");
		System.out.println("Content-Length: " + Integer.parseInt(contentLength));
		Assert.assertTrue(Integer.parseInt(contentLength) < 6000);
		logger.info("-------------Ended vldContentLength-------------");
	}

	@Test
	public void vldCookies() {
		logger.info("-------------Started vldCookies-------------");
		String cookie = response.cookie("sfaf");

	}

	@AfterClass
	public void tearDown() {
		logger.info("-------------Ended TC002_GET_Employee-------------");

	}

}
