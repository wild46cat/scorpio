package com.xueyou.scorpio.shrio;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class myRealm extends AuthorizingRealm {
    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            String userName = (String) getAvailablePrincipal(principalCollection);
            SimpleAccount simpleAccount = new SimpleAccount("1", "a", "a");
            simpleAccount.addRole("worker");
            simpleAccount.addStringPermission("eat2");
            return simpleAccount;
        } else {
            return null;
        }
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            //认证
            if (StringUtils.equals("a", username) && StringUtils.equals("a", password)) {
                return new SimpleAccount("1", password, username);
            } else {
                return null;
            }
        } else {
            return new SimpleAccount("1", password, username);
        }
    }
}
