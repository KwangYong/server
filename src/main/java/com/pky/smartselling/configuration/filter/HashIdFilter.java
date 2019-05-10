package com.pky.smartselling.configuration.filter;

import com.pky.smartselling.configuration.constant.HttpRequestAttributes;
import com.pky.smartselling.controller.HashId;
import com.pky.smartselling.util.HashIdsUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class HashIdFilter  extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map pathVariables = (Map)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if(pathVariables != null) {
            String id = (String)pathVariables.get(HttpRequestAttributes.HASHID);
            Long decode = HashIdsUtil.decode(id);
            if(decode == null) {
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                return false;
            }
            request.setAttribute(HttpRequestAttributes.HASHID, new HashId(decode));
        }

        return super.preHandle(request, response, handler);
    }
}
