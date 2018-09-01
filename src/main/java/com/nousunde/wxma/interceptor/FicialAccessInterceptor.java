package com.nousunde.wxma.interceptor;

import com.nousunde.wxma.utils.StateMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.BiConsumer;

@Component
public class FicialAccessInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("---> ficial access preHandle {} {}", request.getRemoteAddr(), request.getRequestURL());

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String sName = parameterNames.nextElement();
            logger.debug("  {}: {}", sName, request.getParameter(sName));
        }

        String sessionid = request.getParameter("sessionid");
        if (sessionid.isEmpty() || sessionid == "") {
            StateMsg paramErr = StateMsg.REQUEST_PARAM_ERR;
            logger.error("   {}", paramErr.toString());
            response.sendError(paramErr.getState(), paramErr.getErrmsg());
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
