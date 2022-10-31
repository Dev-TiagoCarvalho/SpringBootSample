package com.findmore.serverapp.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filters are not a part in the Spring Pipeline.
 * The filters are supported by the Servlet and not the Spring Pipeline, and that's why they are not annotated with @Component.
 * To add a filter to the pipeline use the FilterRegistrationBean.
 */

public class LoggerFilter extends HttpFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFilter.class);

    /**
     * This method will be executed for every HTTP Request where the LoggerFilter applies.
     * To process data:
     *  - Before the request reaches the handler -> the code should be before the chain.doFilter call.
     *  - After the request was processed by the handler -> the code should be after the chain.doFilter call.
     * When overriding a HttpFilter.doFilter method is required a call to the chain.doFilter in order to ensure that the
     * next filters will also be executed properly.
     *
     * @param request The request to process
     * @param response The response associated with the request
     * @param chain Provides access to the next filter in the chain for this filter to pass the request and response
     * to for further processing
     */

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        LOGGER.info(request.getMethod() + ": " + request.getRequestURI());
        chain.doFilter(request, response);
    }
}
