package com.proface.api.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfaceLogger {

	private static Logger LOG = LoggerFactory.getLogger(ProfaceLogger.class);

	@Before("execution(public * com.proface.api.controllers.ProfaceController.*(..))")
	public void logControllerCalling(JoinPoint point) {
		log("CONTROLLER", "Calling", point.getSignature().toString());
	}

	@Before("execution(public * com.proface.api.services.impl.ProfaceService.*(..))")
	public void logServiceCalling(JoinPoint point) {
		log("SERVICE", "Calling", point.getSignature().toString());
	}

	@AfterReturning("execution(public * com.proface.api.services.impl.ProfaceService.*(..))")
	public void logServiceSucces(JoinPoint point) {
		log("SERVICE", "Success", point.getSignature().toString());
	}

	@AfterThrowing(pointcut = "execution(public * com.proface.api.services.impl.ProfaceService.*(..))", throwing = "ex")
	public void logServiceException(RuntimeException ex) {
		log("SERVICE", "Error", ex.toString());
	}

	@AfterReturning(pointcut = "execution(public * com.proface.api.controllers.ProfaceController.*(..))", returning = "response")
	public void logControllerSucces(JoinPoint point, ResponseEntity<?> response) {
		log("CONTROLLER", "Status", response.getStatusCode().name());
		if (response.getBody() != null) {
			log("CONTROLLER", "Reponse", response.getBody().toString());
		}
		log("CONTROLLER", "Success", point.getSignature().toString());
	}

	@AfterThrowing(pointcut = "execution(public * com.proface.api.controllers.ProfaceController.*(..))", throwing = "ex")
	public void logControllerException(RuntimeException ex) {
		log("CONTROLLER", "Error", ex.toString());
	}

	private void log(String packageName, String action, String message) {
		LOG.info("[{}] {} -> {}", packageName, action, message);
	}

}
