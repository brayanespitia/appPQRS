package com.appPQRS.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

public class LoginSuccesHandler  extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
		
		FlashMap flashMap = new FlashMap();
		flashMap.put("success", "hola " + authentication.getName() +"a iniciado sesion con exito");
		
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
		
		if(authentication !=null) {
			logger.info("el usuario " + authentication.getName() + "a iniciado sesion con exxito");
			
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
