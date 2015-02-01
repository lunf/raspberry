package com.jmango360.server.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jmango360.server.cont.JmErrorCont;
import com.jmango360.server.core.components.services.UserDomainService;
import com.jmango360.server.model.JmError;
import com.jmango360.server.model.MobileAccount;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * This class will handle all the requests that are related to drivers
 * @author alexandra
 *
 */
@RestController
@RequestMapping(value = "/services/rest/drivers", produces = { "application/json" })
public class DriversController {

	@Autowired
	private UserDomainService userDomainService;
		
	@ApiOperation(value = "Register driver account", notes = "Allow taxi driver register an account on JMango system", httpMethod = "POST", response = MobileAccount.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Process error", response = JmError.class),
			@ApiResponse(code = 405, message = "Invalid input", response = JmError.class) })
	@RequestMapping(value = "/{accesstoken}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseEntity<?> createMobileAccount(
			@ApiParam(name = "accesstoken", required = true, value = "String") @PathVariable("accesstoken") String accesstoken,
			@ApiParam(name = "body", required = true, value = "MobileAccount object") @RequestBody MobileAccount account) {

		JmError error = new JmError();
		error.setCode(JmErrorCont.GENERAL_ERROR.getCode());
		error.setUserMessage(JmErrorCont.GENERAL_ERROR.getUserMessage());
		error.setDeveloperMessage(JmErrorCont.GENERAL_ERROR.getTechnicalMessage());

		userDomainService.add(account);
		
		return new ResponseEntity<>(error, HttpStatus.ACCEPTED);
	}
}
