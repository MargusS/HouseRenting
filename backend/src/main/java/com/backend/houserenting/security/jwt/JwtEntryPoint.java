package com.backend.houserenting.security.jwt;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Comprueba el token
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //Test de desarrollo
        logger.error("Fail on commence method");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");

    }
}
