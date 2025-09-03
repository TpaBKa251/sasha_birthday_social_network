package com.example.sasha_birthday_social_network.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        log.info(">>> Incoming: " + req.getMethod() + " " + req.getRequestURI() +
                " | Origin=" + req.getHeader("Origin") +
                " | Headers=" + req.getHeaderNames().asIterator().toString());

        chain.doFilter(request, response);

        HttpServletResponse res = (HttpServletResponse) response;
        log.info("<<< Response: " + res.getStatus());
    }
}
