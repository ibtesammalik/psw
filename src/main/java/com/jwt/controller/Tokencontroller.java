package com.jwt.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.config.Iconstants;
import com.jwt.config.JwtTokenUtil;
import com.jwt.dto.response.ResponseUnauthorize;
import com.jwt.dto.response.TokenAcquisitionResponse;
import com.jwt.dto.response.TokenIntrospectionResponse;
import com.jwt.model.User;
import com.jwt.service.TokenMangementService;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/mcib/connect")
public class Tokencontroller {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@Autowired
	private TokenMangementService tokenService;

	@RequestMapping(value= "/token", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getToken(@RequestHeader HttpHeaders headers,	@RequestParam Map<String, String> tokenParma) throws ServletException {
		try {
			String jwttoken = "";
			User login= new  User();
			login.setClient_id(tokenParma.get("client_id"));login.setClient_secret(tokenParma.get("client_secret"));
			if( headers.get("Authorization")==null) {
				if(login.getClient_id().isEmpty() || login.getClient_secret().isEmpty())
					return new ResponseEntity<String>("Username or password cannot be empty.", HttpStatus.BAD_REQUEST);
				
				String name = login.getClient_id(), 
						password = login.getClient_secret();

				if(!(Iconstants.CLIENT_ID.equalsIgnoreCase(name) && Iconstants.CLIENT_SECRET.equalsIgnoreCase(password)))
					return new ResponseEntity<String>("Invalid credentials. Please check the username and password.", HttpStatus.UNAUTHORIZED);
				else {
					// Creating JWT using the user credentials.
					/*
					 * Map<String, Object> claims = new HashMap<String, Object>(); claims.put("usr",
					 * login.getClient_id()); claims.put("sub", "Authentication token");
					 * claims.put("iss", Iconstants.ISSUER); claims.put("rol",
					 * "Administrator, Developer"); claims.put("iat",
					 * LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
					 * ));
					 */

					final UserDetails userDetails = jwtInMemoryUserDetailsService
							.loadUserByUsername(Iconstants.CLIENT_ID);

					jwttoken =  jwtTokenUtil.generateToken(userDetails);

					Map<String, Object> out =tokenService.addToken(new TokenAcquisitionResponse(jwttoken,  jwtTokenUtil.JWT_TOKEN_VALIDITY, Iconstants.BEARER_TOKEN.replaceAll(" ", ""), Iconstants.SCOPE), "200");
					if("S".equalsIgnoreCase((String) out.get("P_WSTSTS"))) {
						System.out.println("Returning the following token to the user= "+ jwttoken);
						TokenAcquisitionResponse token= new TokenAcquisitionResponse(jwttoken, jwtTokenUtil.JWT_TOKEN_VALIDITY , "Bearer", Iconstants.SCOPE);
						return  ResponseEntity
								.status(HttpStatus.OK)
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.body(token);
						
					}
					else {
						return  ResponseEntity
								.status(HttpStatus.NOT_ACCEPTABLE)
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.body((String) out.get("P_STS_DESC"));
						
					}
				}
			}
			else {
				return new ResponseEntity<String>("BadRequest", HttpStatus.BAD_REQUEST);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("BadRequest", HttpStatus.BAD_REQUEST);
		}
	}

	

	@RequestMapping(value= "/introspect", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> welcome(@RequestHeader HttpHeaders headers,@RequestParam Map<String, String> name) {
		try {
			if( headers.get("Authorization")!=null&&(!headers.get("Authorization").toString().substring(1,7).equalsIgnoreCase("Bearer")) ) {


				Map<String, Object> out =tokenService.getForInActiveToken(new StringBuilder(name.get("Token")), "AD");
				if("S".equalsIgnoreCase((String) out.get("P_WSTSTS"))) {
					Claims cl = jwtTokenUtil.getAllClaimsFromToken(name.get("Token"));

					TokenIntrospectionResponse token= new TokenIntrospectionResponse(
							cl.get("nbf").toString(),
							cl.get("exp").toString(),
							cl.get("aud").toString(),
							cl.get("sub").toString(),
							cl.get("jti").toString(),
							cl.get("iat").toString(),
							"active","adiscope");

					return  ResponseEntity
							.status(HttpStatus.OK)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(token);
				}
				else {
					ResponseUnauthorize code=	new ResponseUnauthorize(LocalDateTime.now(),"200","Token Inactive",out.get("P_WSTSTS_DESC").toString(),"/introspect");
					return  ResponseEntity
							.status(HttpStatus.OK)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.body(code);
				}
			}

			else {


				ResponseUnauthorize code=	new ResponseUnauthorize(LocalDateTime.now(),"401","Unauthorized","Unauthorized","/introspect");
				return ResponseEntity
						.status(HttpStatus.UNAUTHORIZED)
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(code);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("BadRequest", HttpStatus.BAD_REQUEST);
		}
	}


}