package com.yonyou.hotusm.common.security.session;

import com.google.common.collect.Sets;
import com.yonyou.hotusm.common.config.Global;
import com.yonyou.hotusm.common.web.Servlets;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * @author Hotusm
 *         v-2015-10-28
 */
public class CacheSessionDAO extends EnterpriseCacheSessionDAO implements SessionDAO {


    @Override
    protected Serializable doCreate(Session session) {
        HttpServletRequest request = Servlets.getRequest();
        if (request != null) {
            String uri = request.getRequestURI();
            if (Servlets.isStaticFile(uri)) {
                return null;
            }
        }
        super.doCreate(session);
        //System.out.println("doCreate:"+" sessionId"+session.getId());
        return session.getId();
    }

    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        //System.out.println("readSession:"+" sessionId"+sessionId);
        //System.out.println();
        try {
            Session s = null;
            HttpServletRequest request = Servlets.getRequest();
            if (request != null) {
                String uri = request.getRequestURI();
                if (Servlets.isStaticFile(uri)) {
                    return null;
                }
                s = (Session) request.getAttribute("session_" + sessionId);
            }

            if (s != null) {
                return s;
            }
            Session session = super.readSession(sessionId);
            if (request != null && session != null) {
                request.setAttribute("session_" + sessionId, session);
            }
            return session;
        } catch (Exception e) {

            return null;
        }

    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        //System.out.println("doReadSession:"+" sessionId"+sessionId);
        return super.doReadSession(sessionId);
    }


    @Override
    protected void doUpdate(Session session) {
//		System.out.println("doUpdate"+" sessionId"+session.getId());
        if (session == null || session.getId() == null) {
            return;
        }
        HttpServletRequest request = Servlets.getRequest();
        if (request != null) {
            String uri = request.getRequestURI();
            if (Servlets.isStaticFile(uri)) {
                return;
            }
            if (org.apache.commons.lang.StringUtils.startsWith(uri, Global.getConfig("web.view.prefix"))
                    && org.apache.commons.lang.StringUtils.endsWith(uri, Global.getConfig("web.view.suffix"))) {
                return;
            }
            //手动控制不更新session
            String updateSession = request.getParameter("updateSession");
            if (Global.FALSE.equals(updateSession) || Global.NO.equals(updateSession)) {
                return;
            }
        }
        super.doUpdate(session);
    }

    @Override
    protected void doDelete(Session session) {
        //System.out.println("doDelete");
        if (session == null || session.getId() == null) {
            return;
        }
        super.doUpdate(session);
    }


    public Collection<Session> getActiveSessions(boolean includeLeave) {

        return null;
    }

    public Collection<Session> getActiveSessions(boolean includeLeave,
                                                 Object principal, Session filterSession) {

        if (includeLeave && principal == null) {
            return this.getActiveSessions();
        }
        Set<Session> sessions = Sets.newHashSet();
        for (Session session : getActiveSessions()) {
            boolean isActiveSession = true;

        }
        return null;
    }

}
