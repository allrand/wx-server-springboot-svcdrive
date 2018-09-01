package com.nousunde.wxma.interceptor;

import com.nousunde.wxma.repository.SessionRepository;
import com.nousunde.wxma.utils.StateMsg;
import me.chanjar.weixin.common.session.StandardSessionManager;
import me.chanjar.weixin.common.session.WxSession;
import me.chanjar.weixin.common.session.WxSessionManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class UserSesnInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SessionRepository sessionRepository;

    private final WxSessionManager sessionManager = new StandardSessionManager();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("---> user sesn preHandle {} {}", request.getRemoteAddr(), request.getRequestURL());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            String value = request.getParameter(element);
            logger.debug("  {}: {}", element, value);
            if (value.isEmpty() || value.equals("")) {
                StateMsg paramErr = StateMsg.REQUEST_PARAM_ERR;
                response.sendError(paramErr.getState(), paramErr.getErrmsg());
                logger.error("   {} {}", element, paramErr.toString());
                return false;
            }
        }

        String servletPath = request.getServletPath();
        if (servletPath.isEmpty() || servletPath.equals("")) {
            StateMsg paramErr = StateMsg.REQUEST_PARAM_ERR;
            response.sendError(paramErr.getState(), paramErr.getErrmsg());
            logger.error("   {}", paramErr.toString());
            return false;
        } else {
            boolean dispname = false;
            WxSession sdriveSession = null;
            switch (servletPath) {
                case "/session/open":
                    String jscode = request.getParameter("jscode");
                    if (StringUtils.isBlank(jscode)){
                        StateMsg paramErr = StateMsg.REQUEST_PARAM_ERR;
                        logger.error("   {}",paramErr.toString());
                        response.sendError(paramErr.getState(), paramErr.getErrmsg());
                        return false;
                    }
                    String httpSessionId = request.getSession().getId();
                    sdriveSession = sessionManager.getSession(httpSessionId);

                    logger.debug("httpSessionId: {}", httpSessionId);
                    request.setAttribute("sessionid", httpSessionId);
                    sdriveSession.setAttribute("state", -1000);
                    sessionRepository.saveSession(httpSessionId, sdriveSession);
                    break;
                case "/user/register":
                    dispname = StringUtils.isBlank(request.getParameter("dispname"));
                case "/user/login":
                    boolean sessionid = StringUtils.isBlank(request.getParameter("sessionid"));
                    boolean username = StringUtils.isBlank(request.getParameter("username"));
                    boolean password = StringUtils.isBlank(request.getParameter("password"));
                    if (sessionid || username || password ){
                        StateMsg paramErr = StateMsg.REQUEST_PARAM_ERR;
                        logger.error("   {}",paramErr.toString());
                        response.sendError(paramErr.getState(), paramErr.getErrmsg());
                        return false;
                    }
                    sdriveSession = sessionRepository.getWxSessionResult(request.getParameter("sessionid"));

                    break;
                default:
                    logger.info("default servletPath: {}", servletPath);

            }
            if (sdriveSession == null) {
                StateMsg svcUnknownErr = StateMsg.SVC_UNKNOWN_ERR;
                logger.error("   {}", svcUnknownErr.toString());
                response.sendError(svcUnknownErr.getState(), svcUnknownErr.getErrmsg());
                return false;
            }
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
