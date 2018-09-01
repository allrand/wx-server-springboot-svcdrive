package com.nousunde.wxma.repository;

import me.chanjar.weixin.common.session.WxSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class SessionRepository {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 内存型的存储方式 -> Map<>SessionId-WxSession</>
     */
    private final ConcurrentMap<String, WxSession> repos
            = new ConcurrentHashMap<>();

    /**
     * @param session {@link String} 对象
     * @return 如果保存成功，返回 <code>true</code>
     * 否则，返回<code>false</code>
     */
    public boolean saveSession(String session, WxSession wxSession) {
//        logger.info("{} - {}", repos, repos.size());
        boolean containsKey = repos.containsKey(session);
        if (containsKey) {
            WxSession sesnStored = repos.get(session);
//            logger.debug("\n{} \n{}", sesnStored, wxSession);
            if (sesnStored.equals(wxSession))
                return true;
            else
                return repos.replace(session, sesnStored, wxSession);
        }

        boolean b = repos.put(session, wxSession) == null;
        return b;
    }

    public WxSession getWxSessionResult(String sessionId) {
//        logger.info("{} - {}", repos, repos.size());
        if (sessionId.isEmpty() || sessionId == null)
            return null;
        if (repos.size() == 0)
            return null;

        return repos.get(sessionId);

    }

    public Collection<WxSession> getAllSessions() {
        if (repos.size() == 0)
            return null;
        return repos.values();
    }
}
