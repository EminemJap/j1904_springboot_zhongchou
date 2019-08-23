package com.qf.j1904.config;

import com.qf.j1904.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> map=new HashMap<>();
        map.put("/main","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("/login");
        return shiroFilterFactoryBean;
    }

    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();

        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }

    @Bean("myRealm")
    public MyRealm myRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher hashedCredentialsMatcher){
        MyRealm myRealm=new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        myRealm.setAuthorizationCachingEnabled(false);
        return myRealm;
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return  defaultAdvisorAutoProxyCreator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
      AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
      authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
      return authorizationAttributeSourceAdvisor;
    }
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");

        return hashedCredentialsMatcher;
    }
}
