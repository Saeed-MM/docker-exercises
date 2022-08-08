package com.tosan.docker.exercises.helloworldrestapi.Logging;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author S.Mokhatri
 * @since 8/8/2022
 */
@ControllerAdvice
@RequiredArgsConstructor
public class LoggingResponseBody implements ResponseBodyAdvice<Object> {

    private final RestApiLogger logger;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        if (response instanceof ServletServerHttpResponse) {
            logger.LogResponse(((ServletServerHttpResponse) response).getServletResponse(), body);
        }
        return body;
    }
}
