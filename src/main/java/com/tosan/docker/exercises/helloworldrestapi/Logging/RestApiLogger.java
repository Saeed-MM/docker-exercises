package com.tosan.docker.exercises.helloworldrestapi.Logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author S.Mokhatri
 * @since 8/8/2022
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RestApiLogger {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void LogRequest(HttpServletRequest request, Object body) {
        RequestLogInfo logInfo = new RequestLogInfo();
        logInfo.setHeaders(getHeaders(request));
        logInfo.setParams(getParams(request));
        logInfo.setBody(body);
        logInfo.setRequestURI(request.getRequestURI());
        logInfo.setHttpMethod(request.getMethod());
        log.info(MessageFormat.format("Request: {0}", objectMapper.writeValueAsString(logInfo)));
    }

    @SneakyThrows
    public void LogResponse(HttpServletResponse response, Object body) {
        ResponseLogInfo logInfo = new ResponseLogInfo();
        logInfo.setHttpStatus(response.getStatus());
        logInfo.setBody(body);
        log.info(MessageFormat.format("Response: {0}", objectMapper.writeValueAsString(logInfo)));
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> headersMap = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                headersMap.put(headerName, request.getHeader(headerName));
            }
        }
        return headersMap;
    }

    private Map<String, String> getParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            params.put(paramName, request.getParameter(paramName));
        }
        return params;
    }

    @Getter
    @Setter
    private class RequestLogInfo {
        private Map<String, String> headers;
        private Map<String, String> params;
        private Object body;
        private String requestURI;
        private String httpMethod;
    }

    @Getter
    @Setter
    private class ResponseLogInfo {
        private int httpStatus;
        private Object body;
    }
}
