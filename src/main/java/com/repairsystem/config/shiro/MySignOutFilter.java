package com.repairsystem.config.shiro;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class MySignOutFilter extends LogoutFilter {
    private static final Logger log = LoggerFactory.getLogger(MySignOutFilter.class);

    private RedisTemplate redisTemplate ;

    public MySignOutFilter(){

    }

    public MySignOutFilter(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);

        // Check if POST only logout is enabled
        if (isPostOnlyLogout()) {

            // check if the current request's method is a POST, if not redirect
            if (!WebUtils.toHttp(request).getMethod().toUpperCase(Locale.ENGLISH).equals("POST")) {
                return onLogoutRequestNotAPost(request, response);
            }
        }

        String redirectUrl = getRedirectUrl(request, response, subject);
        //try/catch added for SHIRO-298:
        try {

          //登出时从session获取的cookieId
          String cookieId = (String) subject.getSession().getId();
          System.out.println(cookieId);
          Cookie[] cookies = ((HttpServletRequest)request).getCookies();
            for (Cookie cookie:cookies) {
              //"登出时从cookie获取得到的cookieId
                if(cookieId.equals(cookie.getName())){
                  System.out.println(cookie.getValue());
                  redisTemplate.delete(cookie);
                }
            }
            subject.logout();
        } catch (SessionException ise) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }
        issueRedirect(request, response, redirectUrl);
        return false;
    }

}
