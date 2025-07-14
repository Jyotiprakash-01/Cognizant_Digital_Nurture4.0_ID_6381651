package com.cognizant.spring_learn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	private static final Logger LOGGER=LoggerFactory.getLogger("AuthenticationController.java");
	@GetMapping("/authenticate")
	public Map<String,String> authenticate(@RequestHeader("Authorization") String authHeader){
		LOGGER.info("Start");
		LOGGER.debug(authHeader);
		Map<String,String> map=new HashMap<String,String>();
		
		String user=getUser(authHeader);
		String token=generateJwt(user);
		map.put("token",token);
		LOGGER.debug("Decoded User is : {}",user);
		LOGGER.info("End");
		return map;
	}
	private String getUser(String authHeader) {
		String encodedCredential=authHeader.substring(6).trim();
		LOGGER.debug("value:"+encodedCredential);
		byte []decodedBytes=Base64.getDecoder().decode(encodedCredential);
		String decodedUser=new String(decodedBytes,StandardCharsets.UTF_8);
		LOGGER.debug(decodedUser);
		int index=decodedUser.indexOf(":");
		return decodedUser.substring(0, index);		
	}
	private String generateJwt(String user) {
		LOGGER.info("Start generate jwt");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		
		//20 mins =1200000ms
		builder.setExpiration(new Date(new Date().getTime()+1200000));
		
		builder.signWith(SignatureAlgorithm.HS256,"secretkey");
		
		String token=builder.compact();
		LOGGER.info("End generate jwt");
		return token;
	}
}
