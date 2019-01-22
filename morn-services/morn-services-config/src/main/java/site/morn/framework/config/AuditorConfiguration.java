package site.morn.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import site.morn.context.UserAuditorAware;

/**
 * 修订配置
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/22
 */
@Configuration
public class AuditorConfiguration {

  /**
   * 注册修订人配置
   *
   * @return 修订人配置
   */
  @Bean
  public AuditorAware auditorAware() {
    return new UserAuditorAware();
  }
}
