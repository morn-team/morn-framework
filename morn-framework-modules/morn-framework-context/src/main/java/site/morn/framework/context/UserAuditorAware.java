package site.morn.framework.context;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

/**
 * 修订人信息
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/22
 */
public class UserAuditorAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.ofNullable(AccountContext.currentUsername());
  }
}
