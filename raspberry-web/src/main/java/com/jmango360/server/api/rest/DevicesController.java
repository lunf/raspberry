package com.jmango360.server.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jmango360.server.cont.JmErrorCont;
import com.jmango360.server.model.JmError;
import com.jmango360.server.model.MobileDevice;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * This class will handle all actions that are related to mobile devices
 * 
 * @author alexandra
 *
 */

@RestController
@RequestMapping(value = "/services/rest/devices", produces = { "application/json" })
public class DevicesController {

	@ApiOperation(value = "Register device with the system", notes = "Allow mobile register with the JMango system", httpMethod = "POST", response = MobileDevice.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Process error", response = JmError.class),
			@ApiResponse(code = 405, message = "Invalid input", response = JmError.class) })
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseEntity<?> registerMobileDevice(
			@ApiParam(name = "body", required = true, value = "MobileDevice object") @RequestBody MobileDevice device) {

		JmError error = new JmError();
		error.setCode(JmErrorCont.GENERAL_ERROR.getCode());
		error.setUserMessage(JmErrorCont.GENERAL_ERROR.getUserMessage());
		error.setDeveloperMessage(JmErrorCont.GENERAL_ERROR
				.getTechnicalMessage());

		return new ResponseEntity<>(error, HttpStatus.ACCEPTED);
	}
}
