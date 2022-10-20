package com.nagarro.access.managemen.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySimpleUrlAuthenticationSuccessHandler
implements AuthenticationSuccessHandler {

  

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, 
    HttpServletResponse response, Authentication authentication)
    throws IOException {

	  String url =((HttpServletRequest)request).getRequestURL().toString();
	  String queryString = ((HttpServletRequest)request).getQueryString();
	  
  }
  
}
