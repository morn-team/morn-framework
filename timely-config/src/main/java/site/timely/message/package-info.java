/**
 * 国际化配置
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/16
 * @since 1.0-SNAPSHOT
 */
package site.timely.message;

import java.util.Locale;

/**
 * 常量
 */
class Constant {

    /**
     * 从客户端(请求头)获取用户语言环境
     *
     * @see org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
     */
    static final String RESOLVER_ACCEPT_HEADER = "acceptHeader";

    /**
     * 从session获取/记录用户语言环境
     *
     * @see org.springframework.web.servlet.i18n.SessionLocaleResolver
     */
    static final String RESOLVER_SESSION = "session";

    /**
     * 从cookie获取/记录用户语言环境
     *
     * @see org.springframework.web.servlet.i18n.CookieLocaleResolver
     */
    static final String RESOLVER_COOKIE = "cookie";

    /**
     * 固定用户语言环境
     *
     * @see org.springframework.web.servlet.i18n.FixedLocaleResolver
     */
    static final String RESOLVER_FIXED = "fixed";

    /**
     * 默认语言环境解析器
     *
     * @see org.springframework.web.servlet.i18n.CookieLocaleResolver
     */
    static final String DEFAULT_RESOLVER = RESOLVER_COOKIE;

    /**
     * 默认语言
     *
     * @see Locale
     */
    static final String DEFAULT_LANGUAGE = "zh";

    /**
     * Cookie默认有效期 - 1个月
     *
     * @see org.springframework.web.servlet.i18n.CookieLocaleResolver
     */
    static final Integer COOKIE_MAX_AGE = 2592000;

    /**
     * Cookie默认有效期 - 1个月
     *
     * @see org.springframework.web.servlet.i18n.CookieLocaleResolver
     */
    static final String DEFAULT_COOKIE_MAX_AGE = "2592000";
}