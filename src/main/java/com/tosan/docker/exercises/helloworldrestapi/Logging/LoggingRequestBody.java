package com.tosan.docker.exercises.helloworldrestapi.Logging;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

/**
 * @author S.Mokhatri
 * @since 8/8/2022
 */
@ControllerAdvice
@RequiredArgsConstructor
public class LoggingRequestBody extends RequestBodyAdviceAdapter {

    private final HttpServletRequest httpServletRequest;
    private final RestApiLogger logger;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                Class<? extends HttpMessageConverter<?>> converterType) {
        logger.LogRequest(httpServletRequest, body);
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
