package site.morn.shiro;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro配置
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Configuration
public class ShiroConfiguration {

  /**
   * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
   * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
   */
  @Bean
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    log.info("ShiroConfiguration.getLifecycleBeanPostProcessor()");
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public SimpleCookie rememberMeCookie() {
    log.info("ShiroConfiguration.rememberMeCookie()");
    // 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
    SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
    // cookie生效时间30天 ,单位秒
    simpleCookie.setMaxAge(259200);
    return simpleCookie;
  }

  //配置核心安全事务管理器
  @Bean
  public SecurityManager securityManager(UserRealm userRealm, ApplicationContext context) {
    DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
    manager.setRealm(userRealm);
    // 注册认证监听器
    Map<String, AuthenticationListener> listeners = context
        .getBeansOfType(AuthenticationListener.class);
    ModularRealmAuthenticator authenticator = (ModularRealmAuthenticator) manager
        .getAuthenticator();
    authenticator.setAuthenticationListeners(listeners.values());
    return manager;
  }

  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

    bean.setSecurityManager(securityManager);
    //配置登录的url和登录成功的url
    bean.setLoginUrl("/login");

    // 注入过滤器和过滤规则
    Map<String, Filter> filters = bean.getFilters();
    // 登录过滤器
    FormAuthenticationFilter loginFilter = new RestLoginFilter();
    loginFilter.setLoginUrl("/login");
    filters.put("authc", loginFilter);
    // 登出过滤器
    LogoutFilter logoutFilter = new RestLogoutFilter();
    filters.put("logout", logoutFilter);
    bean.setFilterChainDefinitionMap(getFilterChainDefinitionMap());
    return bean;
  }

  /* Shiro 注解 */

  @Bean
  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    return new DefaultAdvisorAutoProxyCreator();
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
      SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }

  /**
   * 获取过滤规则
   *
   * @return 过滤规则
   */
  private Map<String, String> getFilterChainDefinitionMap() {

    //配置访问权限
    LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    // 匿名访问
    filterChainDefinitionMap.put("/", "anon");
    filterChainDefinitionMap.put("/app/**", "anon");
    filterChainDefinitionMap.put("/css/**", "anon");
    filterChainDefinitionMap.put("/fonts/**", "anon");
    filterChainDefinitionMap.put("/img/**", "anon");
    filterChainDefinitionMap.put("/js/**", "anon");
    filterChainDefinitionMap.put("/l10n/**", "anon");
    filterChainDefinitionMap.put("/tpl/**", "anon");
    filterChainDefinitionMap.put("/vendor/**", "anon");
    filterChainDefinitionMap.put("/**/*.js", "anon");
    filterChainDefinitionMap.put("/**/*.css", "anon");
    filterChainDefinitionMap.put("/**/*.jpg", "anon");
    filterChainDefinitionMap.put("/**/*.png", "anon");
    filterChainDefinitionMap.put("/logout*", "logout");

    // 认证访问
    filterChainDefinitionMap.put("/**", "authc");
    return filterChainDefinitionMap;
  }
}
