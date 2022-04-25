package com.letiencao.api.v1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letiencao.dto.request.LoginRequest;
import com.letiencao.dto.response.LoginResponse;
import com.letiencao.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationAPI {

	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println("Login Request = " + loginRequest.getEmail() + " " + loginRequest.getPassword());
		LoginResponse loginResponse = userService.login(loginRequest);
		return loginResponse != null ? new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK)
				: new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.NOT_FOUND);
	}

//	@PostMapping("/refresh-token")
//	public ResponseEntity<LoginResponse> getAccessToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
//		LoginResponse loginResponse = userService.refreshToken(refreshTokenRequest);
//		return loginResponse != null ? new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK)
//				: new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.NOT_FOUND);
//	}
//
//	@PostMapping("/send-code")
//	public ResponseEntity<SendCodeResponse> sendCode(@Valid @RequestBody EmailRequest emailRequest,
//			HttpServletRequest request) {
//		SendCodeResponse sendCodeResponse = userService.sendCodeToEmail(emailRequest.getEmail());
//		return sendCodeResponse != null ? new ResponseEntity<SendCodeResponse>(sendCodeResponse, HttpStatus.OK)
//				: new ResponseEntity<SendCodeResponse>(sendCodeResponse, HttpStatus.BAD_REQUEST);
//	}
//
//	@PostMapping("/reset-password")
//	public ResponseEntity<UserDTO> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
//		UserDTO userDTO = userService.resetPassword(resetPasswordRequest);
//		return userDTO != null ? new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK)
//				: new ResponseEntity<UserDTO>(userDTO, HttpStatus.BAD_REQUEST);
//
//	}
}
