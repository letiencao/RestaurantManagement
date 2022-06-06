package com.letiencao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.letiencao.constant.ConstantValues;
import com.letiencao.converter.UserConverter;
import com.letiencao.dto.UserDetailsImpl;
import com.letiencao.dto.request.LoginRequest;

import com.letiencao.dto.request.user.UserInsertionRequest;
import com.letiencao.dto.response.LoginResponse;

import com.letiencao.dto.response.user.UserDTO;
import com.letiencao.entity.RoleEntity;
import com.letiencao.entity.UserEntity;
import com.letiencao.repository.RoleRepository;
import com.letiencao.repository.UserRepository;
import com.letiencao.security.JwtProvider;
import com.letiencao.service.IUserService;

@Service
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

//	@Autowired
//	private RefreshTokenRepository refreshTokenRepository;
//
//	@Autowired
//	private RefreshTokenRepositoryCustom refreshTokenRepositoryCustom;

	@Autowired
	private UserConverter userConverter;

//	@Autowired
//	private RefreshTokenConverter refreshTokenConverter;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public UserDTO insertOne(UserInsertionRequest userInsertionRequest) {
		// Check existed value
		if (findByEmail(userInsertionRequest.getEmail()) == null
				&& findByPhoneNumber(userInsertionRequest.getPhoneNumber()) == null
				&& findByCitizenId(userInsertionRequest.getCitizenId()) == null
				&& userInsertionRequest.getRoleIds().size() > 0) {
			UserEntity userEntity = userConverter.toEntity(userInsertionRequest);
			userEntity.setStatus(ConstantValues.AVAILABLE);
			userEntity.setCreatedDate(System.currentTimeMillis());
			userEntity.setCreatedBy(ConstantValues.CREATED_BY);
			// Encoding Password
			userEntity.setPassword(bCryptPasswordEncoder.encode(userInsertionRequest.getPassword()));
			// Check the valid role ID from input
			List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
			for (Integer id : userInsertionRequest.getRoleIds()) {
				roleEntities.add(roleRepository.findById(id).get());
			}
			userEntity.setRoleEntities(roleEntities);

			return userConverter.toDTO(userRepository.save(userEntity));
		}
		return null;

	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		try {
			// Check The Email existed
			UserEntity userEntity = userConverter.toEntity(findByEmail(loginRequest.getEmail()));
			// Match the input password with the user password through find by email ?
			boolean checkPasswordEncoded = bCryptPasswordEncoder.matches(loginRequest.getPassword(),
					userEntity.getPassword());
			if (checkPasswordEncoded) {
//			RefreshTokenDTO refreshTokenDTO = jwtProvider.generateRefreshToken();
				LoginResponse loginResponse = new LoginResponse(jwtProvider.generateAccessToken(userEntity.getEmail()),
						jwtProvider.generateRefreshToken(userEntity.getEmail()));
				// if the user_id existed in the refresh_token table,the system would have
				// updated
				// In contrary,it would have saved
//			refreshTokenDTO.setUserEntity(userEntity);
//			System.out.println("JIJIJI = " + refreshTokenRepository
//					.save(refreshTokenConverter.toEntity(refreshTokenDTO)).getUserEntity().getId());
//			return refreshTokenRepository.save(refreshTokenConverter.toEntity(refreshTokenDTO)) != null ? loginResponse
//					: null;

				return loginResponse;
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}

		return null;
	}

	@Override
	public UserDTO findByCitizenId(String citizenId) {
		UserEntity userEntity = userRepository.findByCitizenId(citizenId);
		return userEntity != null ? userConverter.toDTO(userEntity) : null;
	}

	@Override
	public UserDTO findByEmail(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
//		System.out.println("User Entity = " + userEntity.toString());
		return userEntity != null ? userConverter.toDTO(userEntity) : null;
	}

	@Override
	public UserDTO findByPhoneNumber(String phoneNumber) {
		UserEntity userEntity = userRepository.findByPhoneNumber(phoneNumber);
		return userEntity != null ? userConverter.toDTO(userEntity) : null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return new UserDetailsImpl(userRepository.findByEmail(email));
	}

//	@Override
//	public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
//		// token request must not be expired
//		String refreshToken = refreshTokenRequest.getRefreshToken();
//		if (jwtProvider.validateToken(refreshToken)) {
//			String email = jwtProvider.getEmailFromJWT(refreshToken);
//			return findByEmail(email) != null ? new LoginResponse(jwtProvider.generateAccessToken(email), refreshToken)
//					: null;
//		}
//		RefreshTokenEntity refreshTokenEntity = refreshTokenRepository.findByToken(refreshToken);
//		if (refreshTokenEntity != null) {
//			// Kiem tra may con hay khong ? Neu con,bo cap cho may 1 access token moi,con
//			// khong,thi cut ve login lai cho tao
//			if (refreshTokenEntity.getExpiryDate() - System.currentTimeMillis() > 0) {
//				// Lay id cua User -> findById -> username
//				UserEntity userEntity = userRepository.findOne(refreshTokenEntity.getUserEntity().getId());
//				LoginResponse loginResponse = new LoginResponse(jwtProvider.generateAccessToken(userEntity.getEmail()),
//						refreshToken, "Bearer", "OK");
//				return loginResponse;
//			} else {
//				return new LoginResponse(null, null, null, "Your token was expired.Login again");
//			}
//		}
//		return null;
//	}

	// gui email de reset password -> luu vao bang refresh token 30s het han
	/**
	 * 1.Kiểm tra xem email truyền lên có trong db hay không? 2.Nếu có thì sinh code
	 * ngẫu nhiên, lưu vào bảng refresh_token,hết hạn trong vòng 35s 3.Gửi code
	 */
//	@Override
//	public SendCodeResponse sendCodeToEmail(String email) {
//		UserEntity userEntity = userConverter.toEntity(findByEmail(email));
//		if (userEntity != null) {
//			RefreshTokenEntity refreshTokenEntity = refreshTokenRepositoryCustom.findByUserId(userEntity.getId());
//			if (refreshTokenEntity != null) {
//				// Generate random code
//				String code = UUID.randomUUID().toString();
//				// update refresh_token by code into refresh_token table
//				refreshTokenEntity.setToken(code);
//				refreshTokenEntity.setExpiryDate(System.currentTimeMillis() + 35000);
//				refreshTokenEntity.setUserEntity(userEntity);
//				refreshTokenRepository.save(refreshTokenEntity);
//
//				// Email message
//				sendEmail(email, code);
//				return new SendCodeResponse(code);
//			}
//		}
//		return null;
//
//	}

	/*
	 * check the refreshToken exists in refresh_token table -> check expired date of
	 * the refreshToken -> find by user id -> encode password -> update password
	 */

//	@Override
//	public UserDTO resetPassword(ResetPasswordRequest resetPasswordRequest) {

//		RefreshTokenEntity refreshTokenEntity = refreshTokenRepository
//				.findByToken(resetPasswordRequest.getRefreshToken());
//
//		long expiredDate = refreshTokenEntity.getExpiryDate() - System.currentTimeMillis();// con han == expiredDate > 0
//																							// && expiredDate <= 35
//
//		if (refreshTokenEntity != null && expiredDate > 0 && expiredDate <= 35000) {
//			UserEntity userEntity = refreshTokenEntity.getUserEntity();
//			userEntity.setPassword(bCryptPasswordEncoder.encode(resetPasswordRequest.getNewPassword()));
//			return userRepository.save(userEntity) != null ? userConverter.toDTO(userEntity) : null;
//		}
//		return null;
//	}

//	public void sendEmail(String email, String code) {
//		// Email message
//		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
//		passwordResetEmail.setFrom("support@demo.com");
//		passwordResetEmail.setTo(email);
//		passwordResetEmail.setSubject("Password Reset Request");
//		passwordResetEmail.setText("To reset your password, please copy and paste the below code :\n" + code);
//
//		mailSender.send(passwordResetEmail);
//	}

}
