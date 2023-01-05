package com.repairsystem.config;

import com.repairsystem.entity.Administrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 当前登录用户信息
 *
 * @Author 张正贤
 * @Date 2022/12/10 1:06
 * @Version 1.0
 */
public class LoginAdminContext {
    private static final Logger log = LoggerFactory.getLogger(LoginAdminContext.class);
    private static ThreadLocal<Administrator> currentContext = new ThreadLocal();

    public LoginAdminContext() {
    }

    /**
     * 设置当前登录用户到线程
     *
     * @param admin
     */
    public static void setLoginAdminContext(Administrator admin) {
        log.info("当前登录用户加入到线程，用户ID为【" + admin.getAdminId() + "】");
        currentContext.set(admin);
    }

    /**
     * 获取当前线程登录用户
     *
     * @return 当前用户
     */
    public static Administrator getLoginAdminContext() {
        return (Administrator) currentContext.get();
    }

    /**
     * 清除当前线程的登录用户信息
     */
    public static void clear() {
        currentContext.remove();
    }
}
