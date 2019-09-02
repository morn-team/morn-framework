package site.morn.framework.autoconfigure;

import org.apache.shiro.mgt.SecurityManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.morn.framework.context.CurrentUserProducer;
import site.morn.framework.shiro.ShiroUserProducer;
import site.morn.framework.user.entity.User;

/**
 * Shiro自动化配置
 *
 * @author timely-rain
 * @since 1.0.0, 2019/4/27
 */
@Configuration
@ConditionalOnClass({SecurityManager.class, User.class})
public class ShiroAutoConfiguration {

  /**
   * 注册Shiro当前用户适配器
   *
   * @return Shiro当前用户适配器
   */
  @Bean
  @ConditionalOnMissingBean
  public CurrentUserProducer<User> currentUserAdapter() {
    return new ShiroUserProducer();
  }
}
