package com.drzewiecki.security.component;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.StringTokenizer;

@Component
public class HttpRequestComponent {
    public String getClientIpAddress() {
        final Optional<HttpServletRequest> currentRequest = getCurrentRequest();

        if (currentRequest.isEmpty()) {
            return null;
        }

        final String xForwardedForHeader = currentRequest.get().getHeader("X-Forwarded-For");
        return StringUtils.isEmpty(xForwardedForHeader)
                ? currentRequest.get().getRemoteAddr()
                : new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
    }

    private Optional<HttpServletRequest> getCurrentRequest() {
        return Optional.ofNullable(RequestContextHolder.getRequestAttributes())
                .filter(requestAttributes -> ServletRequestAttributes.class.isAssignableFrom(requestAttributes.getClass()))
                .map(requestAttributes -> ((ServletRequestAttributes) requestAttributes))
                .map(ServletRequestAttributes::getRequest);
    }
}
