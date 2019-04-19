package site.morn.framework.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import site.morn.framework.context.UserAuditorAware;

/**
 * 修订配置
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/22
 */
@Configuration
public class AuditorAutoConfiguration {

  /**
   * 注册修订人配置
   *
   * @return 修订人配置
   */
  @Bean
  @ConditionalOnMissingBean
  public AuditorAware auditorAware() {
    return new UserAuditorAware();
  }
}
