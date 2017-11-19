package com.jd.start.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * Created by chenjunjun on 2017/11/14.
 */
public class MyRealm implements Realm {
    @Override
    public String getName() {
        return "blahRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return true;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
