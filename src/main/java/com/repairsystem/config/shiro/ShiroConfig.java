package com.repairsystem.config.shiro;

import com.repairsystem.utils.ConstantUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author CheungChingYin
 * @date 2018/11/5
 * @time 14:20
 */
@Configuration
public class ShiroConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

    /**
     * shiro管理生命周期的东西
     *
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager, RedisTemplate redisTemplate) {
        //定义shiroFilterFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置自定义的 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置默认登录的 URL，身份认证失败会访问该 URL;配置拦截需要user/authc身份的跳转路径。
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置成功之后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/main");
        // 设置未授权界面，权限认证失败会访问该 URL
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
        filters.put("logout", new MySignOutFilter(redisTemplate));
        shiroFilterFactoryBean.setFilters(filters);

        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String, String> filterChainMap = new LinkedHashMap<String, String>();

        // TODO 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon 表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/imgs/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/swagger-ui.html", "anon");
        filterChainMap.put("/swagger-*/**", "anon");
        filterChainMap.put("/swagger-ui.html/**", "anon");
        // 登录 URL 放行
        filterChainMap.put("/admin/login", "anon");
        filterChainMap.put("/login", "anon");
        filterChainMap.put("/orders/saveOrders", "anon");
        filterChainMap.put("/orders/uploadImage", "anon");

        //需要认证的接口
        filterChainMap.put("/building/**", "authc");
        filterChainMap.put("/class/**", "authc");
        filterChainMap.put("/completeOrders/**", "authc");
        filterChainMap.put("/orders/**", "authc");
        filterChainMap.put("/QRCode/**", "authc");
        // 配置 logout 过滤器
        filterChainMap.put("/admin/logout", "logout");
        //管理员接口只有超级管理员才能使用
        filterChainMap.put("/admin/**", "authc,roles[超级管理员]");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

        LOGGER.info("====shiroFilterFactoryBean注册完成====");
        return shiroFilterFactoryBean;

    }


    /**
     * 注入自定义Realm
     *
     * @return
     */
    @Bean(name = "myShiroRealm")
    public MyShiroRealm getAdminRealm() {
        MyShiroRealm adminRealm = new MyShiroRealm();
        LOGGER.info("====AdminRealm注册完成=====");
        return adminRealm;
    }

    /**
     * 注入安全管理器
     *
     * @return
     */
    @Bean(name = "securityManager")
    public SecurityManager getSecurityManager(@Qualifier("myShiroRealm") MyShiroRealm adminRealm, RedisTemplate redisTemplate) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(adminRealm);
        //自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager(redisTemplate));
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        LOGGER.info("====securityManager注册完成====");
        return securityManager;
    }

    @Bean(name = "myShiroRealm")
    @DependsOn(value = {"lifecycleBeanPostProcessor", "ShiroRedisCacheManager"})
    public MyShiroRealm myShiroRealm(RedisTemplate redisTemplate) {
        MyShiroRealm shiroRealm = new MyShiroRealm();
        shiroRealm.setCacheManager(redisCacheManager(redisTemplate));
        shiroRealm.setCachingEnabled(true);
        //设置认证密码算法及迭代复杂度
//        shiroRealm.setCredentialsMatcher(credentialsMatcher());
        //认证
        shiroRealm.setAuthenticationCachingEnabled(false);
        //授权
        shiroRealm.setAuthorizationCachingEnabled(false);
        return shiroRealm;
    }

    /**
     * realm的认证算法
     *
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher("md5");
        //迭代次数
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    /**
     * 缓存管理器的配置
     *
     * @param redisTemplate
     * @return
     */
    @Bean(name = "ShiroRedisCacheManager")
    public ShiroRedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
        ShiroRedisCacheManager redisCacheManager = new ShiroRedisCacheManager(redisTemplate);
        //name是key的前缀，可以设置任何值，无影响，可以设置带项目特色的值
        redisCacheManager.createCache("shiro_redis");
        return redisCacheManager;
    }

    /**
     * 配置sessionmanager，由redis存储数据
     */
    @Bean(name = "sessionManager")
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public DefaultWebSessionManager sessionManager(RedisTemplate redisTemplate) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        MyRedisSessionDao redisSessionDao = new MyRedisSessionDao(redisTemplate);
        //这个name的作用也不大，只是有特色的cookie的名称。
        redisSessionDao.setSessionIdGenerator(sessionIdGenerator("starrkCookie"));
        sessionManager.setSessionDAO(redisSessionDao);
        sessionManager.setDeleteInvalidSessions(true);
        SimpleCookie cookie = new SimpleCookie();
        cookie.setName("starrkCookie");
        sessionManager.setSessionIdCookie(cookie);
        sessionManager.setSessionIdCookieEnabled(true);
        return sessionManager;
    }

    /**
     * 自定义的SessionId生成器
     *
     * @param name
     * @return
     */
    public MySessionIdGenerator sessionIdGenerator(String name) {
        return new MySessionIdGenerator(name);
    }

    /**
     * 这个参数是RememberMecookie的名称，随便起。
     * remenberMeCookie是一个实现了将用户名保存在客户端的一个cookie，与登陆时的cookie是两个simpleCookie。
     * 登陆时会根据权限去匹配，如是user权限，则不会先去认证模块认证，而是先去搜索cookie中是否有rememberMeCookie，
     * 如果存在该cookie，则可以绕过认证模块，直接寻找授权模块获取角色权限信息。
     * 如果权限是authc,则仍会跳转到登陆页面去进行登陆认证.
     *
     * @return
     */
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("remenbermeCookie");
        //<!-- 记住我cookie生效时间3天 ,单位秒;-->
        simpleCookie.setMaxAge(ConstantUtils.Cookie.COOKIE_MAX_TIME);
        return simpleCookie;
    }

    /**
     * cookie管理对象;记住我功能
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
}
