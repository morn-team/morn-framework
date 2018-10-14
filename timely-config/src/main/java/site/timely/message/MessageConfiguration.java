package site.timely.message;

import java.util.Locale;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import site.timely.config.ApplicationConstant;

/**
 * 国际化配置
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/16
 * @since 1.0-SNAPSHOT
 */
@Configuration
public class MessageConfiguration {

  /**
   * 读取国际化配置属性
   *
   * @return 国际化配置属性
   */
  @Bean
  @ConfigurationProperties(prefix = ApplicationConstant.MESSAGE_PROPERTIES)
  public MessageProperties getProperties() {
    return new MessageProperties();
  }

  /**
   * 注册解析器
   *
   * @return LocaleResolver
   */
  @Bean
  public LocaleResolver localeResolver() throws Exception {
    MessageProperties properties = getProperties();
    Locale locale = new Locale(properties.getLanguage()); // 默认语言环境
    switch (properties.getResolver()) {
      case Constant.RESOLVER_ACCEPT_HEADER:
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(locale);
        return acceptHeaderLocaleResolver;
      case Constant.RESOLVER_SESSION:
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(locale);
        return sessionLocaleResolver;
      case Constant.RESOLVER_FIXED:
        FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver();
        fixedLocaleResolver.setDefaultLocale(locale);
        return fixedLocaleResolver;
      case Constant.RESOLVER_COOKIE:
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(locale);
        cookieLocaleResolver.setCookieMaxAge(properties.getCookieMaxAge());
        return cookieLocaleResolver;
    }
    throw new Exception("Unknown LocaleResolver");
  }

}
