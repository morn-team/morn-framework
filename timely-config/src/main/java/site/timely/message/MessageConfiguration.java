package site.timely.message;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.Objects;

/**
 * 国际化配置
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.8
 */
@Configuration
@ConfigurationProperties(prefix = "spring.messages")
public class MessageConfiguration {
    /**
     * 解释器类型
     *
     * @apiNote 决定用户语言的获取方式
     * @see MessageHolder
     */
    private String resolver;

    /**
     * 默认语言
     */
    private String language;

    /* Cookie Start */
    /**
     * cookie有效期
     */
    private Integer cookieMaxAge;
    /* Cookie End */

    /**
     * 注册解析器
     *
     * @return LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver() throws Exception {
        if (Objects.isNull(resolver)) resolver = Constant.DEFAULT_RESOLVER;
        switch (resolver) {
            case Constant.RESOLVER_ACCEPT_HEADER:
                AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
                acceptHeaderLocaleResolver.setDefaultLocale(defaultLocale());
                return acceptHeaderLocaleResolver;
            case Constant.RESOLVER_SESSION:
                SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
                sessionLocaleResolver.setDefaultLocale(defaultLocale());
                return sessionLocaleResolver;
            case Constant.RESOLVER_FIXED:
                FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver();
                fixedLocaleResolver.setDefaultLocale(defaultLocale());
                return fixedLocaleResolver;
            case Constant.RESOLVER_COOKIE:
                CookieLocaleResolver resolver = new CookieLocaleResolver();
                resolver.setDefaultLocale(defaultLocale());
                if (Objects.isNull(cookieMaxAge)) cookieMaxAge = Constant.COOKIE_MAX_AGE;
                resolver.setCookieMaxAge(cookieMaxAge);
                return resolver;
        }
        throw new Exception("Unknown LocaleResolver");
    }

    /**
     * 默认语言环境
     *
     * @return 语言环境
     */
    private Locale defaultLocale() {
        if (Objects.isNull(language)) language = Constant.DEFAULT_LANGUAGE;
        return new Locale(language);
    }

    public String getResolver() {
        return resolver;
    }

    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    public Integer getCookieMaxAge() {
        return cookieMaxAge;
    }

    public void setCookieMaxAge(Integer cookieMaxAge) {
        this.cookieMaxAge = cookieMaxAge;
    }
}
