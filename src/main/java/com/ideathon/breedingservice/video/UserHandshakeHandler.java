package com.ideathon.breedingservice.video;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.sun.security.auth.UserPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class UserHandshakeHandler extends DefaultHandshakeHandler implements HandshakeInterceptor{

	
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		// TODO Auto-generated method stub
		ServletServerHttpRequest servletrequest = (ServletServerHttpRequest) request;
        HttpServletRequest httpServletRequest = servletrequest.getServletRequest();
		System.out.println("User is ="+httpServletRequest.getParameter("user"));
		String userName = httpServletRequest.getParameter("user");
		return true;
	}
	
	@Override
	protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
		final String randomId = UUID.randomUUID().toString();
		ServletServerHttpRequest servletrequest = (ServletServerHttpRequest) request;
        HttpServletRequest httpServletRequest = servletrequest.getServletRequest();
		System.out.println("User is ="+httpServletRequest.getParameter("user"));
		String userName = httpServletRequest.getParameter("user");

		// TODO Auto-generated method stub
		return new UserPrincipal(randomId);
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
	}

}
