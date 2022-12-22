package com.qa.API.tests;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.API.base.TestBase;
import com.qa.API.utils.TestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_POST_Employee extends TestBase {

	String empName1 = TestUtils.empName();
	String empSal1 = TestUtils.empSal();
	String empAge1 = TestUtils.empAge();

	@BeforeClass
	public void getAllEmployee() throws InterruptedException {
		logger = Logger.getLogger(TestBase.class);
		logger.info("-------------Started TC003_POST_Employee-------------");

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		JSONObject requestPara = new JSONObject();
		requestPara.put("name", empName1);
		requestPara.put("salary", empSal1);
		requestPara.put("age", empAge1);

		httpRequest.header("Content-Type", "application/json");

		response = httpRequest.request(Method.POST, "/create");

		Thread.sleep(2000);

	}

	@Test
	public void vldResponseBody() {

		logger.info("-------------Started vldResponseBody-------------");

		String responseBody = response.getBody().asString();
		logger.info("ResponseBody is: " + responseBody);
		Assert.assertEquals(responseBody.contains("Successfully! Record has been added."), true);

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
	public void vldCookies() {
		logger.info("-------------Started vldCookies-------------");
		String cookie = response.cookie("sfaf");

	}

	@AfterClass
	public void tearDown() {
		logger.info("-------------Ended TC003_POST_Employee-------------");

	}

}
