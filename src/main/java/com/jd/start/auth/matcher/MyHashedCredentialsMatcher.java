package com.jd.start.auth.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenjunjun on 2017/11/14.
 */
public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher{

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        boolean matches = super.doCredentialsMatch(token, info);
        return matches;
    }
}
