package com.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.service.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

public class Jwtauthfilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		// Fetching the authorization header from the request.
		String authenticationHeader= request.getHeader(Iconstants.HEADER);

		try {
			SecurityContext context= SecurityContextHolder.getContext();
			String username = null;
			String jwtToken = null;
			if(authenticationHeader != null && authenticationHeader.startsWith("Bearer")) {

				final String bearerTkn= authenticationHeader.replaceAll(Iconstants.BEARER_TOKEN, "");
				System.out.println("Following token is received from the protected url= "+ bearerTkn);
				jwtToken=bearerTkn;

				try { 
					username = jwtTokenUtil.getUsernameFromToken(jwtToken); 
				} 
				catch
				(IllegalArgumentException e) 
				{ 
					request.setAttribute("expired","Unable To Get Token");
					System.out.println("Unable to get JWT Token");
				} catch (ExpiredJwtException e) {
					request.setAttribute("expired", "Token Expired");
					System.out.println("JWT Token has expired"); }

				catch(MalformedJwtException e ) {
					request.setAttribute("Token Invalid", "in Valid Token");
					System.out.println("JWT Token has expired"); 
				}
				/*
				 * try { // Parsing the jwt token. Jws<Claims> claims =
				 * Jwts.parser().requireIssuer(Iconstants.ISSUER).setSigningKey(Iconstants.
				 * SECRET_KEY).parseClaimsJws(bearerTkn);
				 * 
				 * // Obtaining the claims from the parsed jwt token. String user= (String)
				 * claims.getBody().get("usr"); String roles= (String)
				 * claims.getBody().get("rol");
				 * 
				 * 
				 * 
				 * // Creating the list of granted-authorities for the received roles.
				 * List<GrantedAuthority> authority= new ArrayList<GrantedAuthority>();
				 * for(String role: roles.split(",")) authority.add(new
				 * SimpleGrantedAuthority(role));
				 * 
				 * // Creating an authentication object using the claims. Myauthtoken
				 * authenticationTkn= new Myauthtoken(user, null, authority); // Storing the
				 * authentication object in the security context.
				 * context.setAuthentication(authenticationTkn); } catch (SignatureException e)
				 * { throw new ServletException("Invalid token."); }
				 */
			}
			//Once we get the token validate it.
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

				// if token is valid configure Spring Security to manually set authentication
				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					// After setting the Authentication in the context, we specify
					// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
			filterChain.doFilter(request, response);
			context.setAuthentication(null);
		} catch(AuthenticationException ex) {
			throw new ServletException("Authentication exception.");
		}
	}
}