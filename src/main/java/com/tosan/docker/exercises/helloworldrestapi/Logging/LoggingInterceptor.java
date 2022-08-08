package com.tosan.docker.exercises.helloworldrestapi.Logging;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author S.Mokhatri
 * @since 8/8/2022
 */
@Component
@RequiredArgsConstructor
public class LoggingInterceptor implements HandlerInterceptor {

    private final RestApiLogger logger;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name()) &&
                request.getMethod().equals(HttpMethod.GET.name())) {
            logger.LogRequest(request, null);
        }
        return true;
    }
}
