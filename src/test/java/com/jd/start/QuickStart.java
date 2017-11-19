package com.jd.start;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenjunjun on 2017/11/13.
 */
public class QuickStart {
    private static final transient Logger log = LoggerFactory.getLogger(QuickStart.class);

    public static void main(String[] args) {
        log.info("My First Apache Shiro Application");
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.isAuthenticated() == false){
            UsernamePasswordToken token = new UsernamePasswordToken("tomcat","chen");
            token.setRememberMe(true);
            try {
                currentUser.login( token );
                //if no exception, that's it, we're done!
            } catch ( UnknownAccountException uae ) {
                //username wasn't in the system, show the an error message?
                log.error("e:",uae);
                System.exit(0);
            } catch ( IncorrectCredentialsException ice ) {
                //password didn't match, try again?
                log.error("e:",ice);
                System.exit(0);
            } catch ( LockedAccountException lae ) {
                //account for that username is locked - can't login.  Show them a message?
                log.error("e:",lae);
                System.exit(0);
            }
        }
        Session session = currentUser.getSession();
        session.setAttribute("uname",currentUser.getPrincipal());
        session.setAttribute("role",currentUser.getPreviousPrincipals());

        log.info("userName:{},role:{}",session.getAttribute("uname"),session.getAttribute("role"));
        currentUser.logout();
        System.exit(0);
    }
}

