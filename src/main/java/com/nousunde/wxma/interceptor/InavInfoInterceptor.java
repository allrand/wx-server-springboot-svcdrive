package com.nousunde.wxma.interceptor;

import com.nousunde.wxma.repository.SessionRepository;
import com.nousunde.wxma.service.DockSvc;
import com.nousunde.wxma.utils.StateMsg;
import me.chanjar.weixin.common.session.WxSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class InavInfoInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private DockSvc dockSvc;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("---> inav info preHandle {} {}", request.getRemoteAddr(), request.getRequestURL());
//                request.getContextPath(), request.getMethod(), request.getSession().getId());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String sName = parameterNames.nextElement();
            logger.info("  {}: {}", sName, request.getParameter(sName));
        }

        String sessionid = request.getParameter("sessionid");
        logger.info("  sessionid:{}", sessionid);
        if (sessionid.isEmpty() || sessionid == ""){
            StateMsg paramErr = StateMsg.REQUEST_PARAM_ERR;
            logger.error("   {}", paramErr.toString());
            response.sendError(paramErr.getState(), paramErr.getErrmsg());
            return false;
        }else {
            WxSession storedSession = sessionRepository.getWxSessionResult(sessionid);
            if (storedSession == null) {
                StateMsg paramErr = StateMsg.REQUEST_PARAM_ERR;
                logger.error("   {}", paramErr.toString());
                response.sendError(paramErr.getState(), paramErr.getErrmsg());
                return false;
            }
            Short userMod = 4430;//Visitors
            Object obj = storedSession.getAttribute("UserMod");
            logger.info("  request userMod: {}", obj);
            if (obj != null) {
                userMod = Short.parseShort(obj.toString());
                if (userMod == 3030){
                    logger.info("--->Administrator");
                }else if (4130 <= userMod && userMod < 4199){
                    logger.info("--->Supper user");
                }else if (4230 <= userMod && userMod < 4299){
                    logger.info("--->Advance user");
                }else if (4330 <= userMod && userMod < 4399){
                    logger.info("--->Normal user");
                }else
                    logger.warn("$$$>Guest visitor");
            } else {
                StateMsg authHavntLogin = StateMsg.AUTH_HAVNT_LOGIN;
                logger.error(authHavntLogin.toString());
                response.sendError(authHavntLogin.getState(), authHavntLogin.getErrmsg());
                //TODO add comment for test!
                return false;
            }
        }

        return true;//放行
//
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
