package com.jmango360.server.api.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jmango360.server.model.JmApplication;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/services/rest/applications", produces = {
		"application/json", "application/xml" })
public class ApplicationController {
	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationController.class);

	@ApiOperation(value = "Find all applications", notes = "Get all applications currently available for logged in users", httpMethod = "GET", response = JmApplication.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Process error"),
			@ApiResponse(code = 405, message = "Invalid input") })
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<List<JmApplication>> applications() {
		JmApplication category = new JmApplication();
		category.setAppKey("12QSAASDQD");
		category.setName("Full Time");
		category.setImage("http://test.com");

		JmApplication person2 = new JmApplication();
		person2.setAppKey("12QSAASDQD");
		person2.setName("Full Time");
		person2.setImage("http://test.com");

		List<JmApplication> persons = new ArrayList<JmApplication>();
		persons.add(category);
		persons.add(person2);
		Collections.sort(persons,
				(p1, p2) -> p1.getName().compareTo(p2.getName()));

		
		return new ResponseEntity<List<JmApplication>>(persons, HttpStatus.ACCEPTED);
	}
}
