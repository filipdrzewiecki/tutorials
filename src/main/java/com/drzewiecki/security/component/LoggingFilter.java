package com.drzewiecki.security.component;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Slf4j
@Component
@WebFilter
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class LoggingFilter extends OncePerRequestFilter {
    @Value("${logging.get_request_logging.enabled}")
    private boolean isGetRequestLoggingEnabled;

    private final static Set<String> NOT_SUPPORTED_URLS = Set.of("swagger", "css", "csrf");

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } finally {
            logRequest(start, request, response);
            MDC.clear();
        }
    }

    private void logRequest(long start, HttpServletRequest request, HttpServletResponse response) {
        final boolean isRequestedMethodLoggingSupported = isGetRequestLoggingEnabled || !request.getMethod().equals(HttpMethod.GET.name());
        if (isRequestedUrlLoggingSupported(request.getRequestURI()) && isRequestedMethodLoggingSupported) {
            long timeElapsed = System.currentTimeMillis() - start;
            log.info("Request: {}, Params: {}, Method: {}, Response status: {}, User: {}, Partner: {}, IP: {}, Lasted: {}ms",
                    request.getRequestURI(), request.getQueryString(), request.getMethod(), response.getStatus(),
                    MDC.get("username"), MDC.get("partner"), MDC.get("ip"), timeElapsed);
        }
    }

    private boolean isRequestedUrlLoggingSupported(String requestURL) {
        return NOT_SUPPORTED_URLS.stream().noneMatch(requestURL::contains);
    }
}
