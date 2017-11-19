package com.jd.start.auth.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by chenjunjun on 2017/11/14.
 */
public class MoreUserRealm  extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String newPassword = new SimpleHash(
                "md5",
                token.getCredentials(),
                ByteSource.Util.bytes("222"),
                2).toHex();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                token.getPrincipal(), //用户名
                newPassword, //密码
                ByteSource.Util.bytes("222"),//salt=username+salt
                "myRealm"  //realm name
        );
        return authenticationInfo;
    }
}
