package com.letiencao.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class JwtProvider {
	// Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
	private final String JWT_SECRET = "letiencao28072000";

	// Thời gian có hiệu lực của chuỗi jwt
	private final long ACCESS_JWT_EXPIRATION = 86400000L;// 1 day

	private final long REFRESH_JWT_EXPIRATION = 604800000L;// 1 week

	// Tạo ra jwt từ thông tin user
	public String generateAccessToken(String email) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + ACCESS_JWT_EXPIRATION);
		// Tạo chuỗi json web token từ username của user.
		return Jwts.builder().setSubject(email).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	public String generateRefreshToken(String email) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + REFRESH_JWT_EXPIRATION);
		// Tạo chuỗi json web token từ username của user.
		return Jwts.builder().setSubject(email).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	// Lấy thông tin user từ jwt
	public String getEmailFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException ex) {
			ex.getMessage();
		} catch (ExpiredJwtException ex) {
			ex.getMessage();
		} catch (UnsupportedJwtException ex) {
			ex.getMessage();
		} catch (IllegalArgumentException ex) {
			ex.getMessage();
		}
		return false;
	}
}