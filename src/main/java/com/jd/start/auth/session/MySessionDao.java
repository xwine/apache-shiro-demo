package com.jd.start.auth.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by chenjunjun on 2017/11/15.
 */
public class MySessionDao implements SessionDAO {
    @Override
    public Serializable create(Session session) {
        return null;
    }

    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        return null;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
