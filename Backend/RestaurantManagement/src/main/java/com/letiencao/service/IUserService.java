package com.letiencao.service;

import com.letiencao.dto.request.LoginRequest;

import com.letiencao.dto.request.user.UserInsertionRequest;
import com.letiencao.dto.response.LoginResponse;

import com.letiencao.dto.response.user.UserDTO;

public interface IUserService {
	// Insert a User
	UserDTO insertOne(UserInsertionRequest userInsertionRequest);

	// Login
	LoginResponse login(LoginRequest loginRequest);

	// Find a User By CitizenId
	UserDTO findByCitizenId(String citizenId);

	// Find a User By Email
	UserDTO findByEmail(String email);

	// Find a User By PhoneNumber
	UserDTO findByPhoneNumber(String phoneNumber);

//	LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
//
//	SendCodeResponse sendCodeToEmail(String email);
//
//	UserDTO resetPassword(ResetPasswordRequest resetPasswordRequest);

}
