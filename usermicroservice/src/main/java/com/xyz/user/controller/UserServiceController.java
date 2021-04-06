package com.xyz.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xyz.user.exception.UserServiceException;
import com.xyz.user.model.request.UserLoginRequest;
import com.xyz.user.model.request.UserRegistrationRequest;
import com.xyz.user.model.response.UserResponse;
import com.xyz.user.service.UserLoginInService;
import com.xyz.user.service.UserRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@Api(value = "User Controller", tags = { "User controller" })
@RestController
@RequestMapping("/user")
public class UserServiceController {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

	@Autowired
	private UserLoginInService loginInService;

	@Autowired
	private UserRegisterService userRegisterService;

	@ApiOperation(value = "Login as a user", notes = "This method allows a user login", response = UserResponse.class)
	@PostMapping("/login")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Page not found"),
			@ApiResponse(code = 200, message = "User login successful", response = UserResponse.class) })
	public ResponseEntity<UserResponse> loginIn(@RequestBody UserLoginRequest userLoginRequest)
			throws UserServiceException {

		logger.info("Entered UserLoginController ; Username : {} ", userLoginRequest.getUsername());
		UserResponse userResponse = loginInService.loginIn(userLoginRequest);
		logger.info("Exited UserLoginController ; Username : {} ", userLoginRequest.getUsername());

		return new ResponseEntity<>(userResponse, HttpStatus.OK);

	}

	@ApiOperation(value = "Registration for an admin or agent", response = UserResponse.class)
	@PostMapping("/register")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Page not found"),
			@ApiResponse(code = 200, message = "User registered successful", response = UserResponse.class) })
	public UserResponse registerUser(@RequestBody UserRegistrationRequest userRegReq) throws UserServiceException {

		logger.info("Entered UserRegisterController , {}", userRegReq.getUsername());

		UserResponse userResponse = userRegisterService.registerUser(userRegReq);

		logger.info("Exited UserRegisterController ; {}", userRegReq.getUsername());

		return userResponse;

	}

}
