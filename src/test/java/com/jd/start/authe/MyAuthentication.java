package com.jd.start.authe;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.SimpleAccount;

/**
 * Created by chenjunjun on 2017/11/14.
 */
public class MyAuthentication implements Authenticator {
    @Override
    public AuthenticationInfo authenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        return new SimpleAccount("tomcat","chen1","blahRealm");
    }
}
