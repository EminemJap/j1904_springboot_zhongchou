package com.qf.j1904.shiro;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        if(!StringUtils.isEmpty(primaryPrincipal)){
            String loginName=(String)primaryPrincipal;
            Set<String> perm=new HashSet<>();
            List<SysPermission> allPermission = sysUserService.findAllPermission(loginName);
            for (SysPermission perms:allPermission) {
                String per_name = perms.getPer_name();
                perm.add(per_name);
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.setStringPermissions(perm);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object principal = token.getPrincipal();
        if(!StringUtils.isEmpty(principal)){
            String loginName=(String)principal;
            SysUser sysUser = sysUserService.findByloginName(loginName);
            ByteSource salt = ByteSource.Util.bytes("abc");
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(loginName,sysUser.getPassword(),salt,getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
