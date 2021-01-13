package com.ajay.security.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ajay.security.api.mastertenant.entity.MasterTenantEntity;
import com.ajay.security.api.mastertenant.service.MasterTenantService;
import com.ajay.security.api.service.UserDetailsServiceImpl;
import com.ajay.security.api.tenant.model.TenantStorage;
import com.ajay.security.api.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private MasterTenantService masterTenantService;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {

		String autherizationHeader = httpServletRequest.getHeader("Authorization");
		String tenantHeader = httpServletRequest.getHeader("X-Tenant");
		String token = null;
		String username = null;
		
		if(tenantHeader!=null)
			System.out.println("Tenant : "+tenantHeader);
		
//		MasterTenantEntity masterTenant = masterTenantService.findByName(tenantHeader);
//		if(masterTenant==null) {
//			throw new BadCredentialsException("Invalid Tenant and user!!");
//		}
		TenantStorage.setCurrentTenent(tenantHeader);

		if (autherizationHeader != null && autherizationHeader.startsWith("Bearer ")) {
			token = autherizationHeader.substring("Bearer ".length());
			username = jwtUtil.extractUsername(token);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			// Validate User
			if (jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	
}
