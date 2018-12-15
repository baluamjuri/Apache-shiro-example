package org.balu.learn.shiro.exception.advice;

import org.apache.shiro.authz.AuthorizationException;
import org.balu.learn.shiro.controller.GatewayController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes=GatewayController.class)
public class GatewayControllerAdvice {
	
	@ExceptionHandler(AuthorizationException.class)
	public String AuthorizationExceptionHandler() {
		return "unauthorized";
	}
}
