package com.amigoscode.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);

        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("Response status: " + res.getStatus());
    }

}
