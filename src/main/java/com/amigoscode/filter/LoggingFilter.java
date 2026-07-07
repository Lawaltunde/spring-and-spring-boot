package com.amigoscode.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

// TODO: 17 - Implement a logging filter:
//  - Annotate this class with @Component
//  - Implement the Filter interface (jakarta.servlet.Filter)
//  - Override the doFilter method
//  - Before calling chain.doFilter(), print the HTTP method and URI:
//    HttpServletRequest req = (HttpServletRequest) request;
//    System.out.println(req.getMethod() + " " + req.getRequestURI());
//  - After calling chain.doFilter(), print the response status:
//    HttpServletResponse res = (HttpServletResponse) response;
//    System.out.println("Response status: " + res.getStatus());

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(req.getMethod() + " " + req.getRequestURI());
        chain.doFilter(request, response);
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("Response status: " + resp.getStatus());
    }
}
