package site.morn.framework.context;

import org.springframework.data.domain.AuditorAware;
import site.morn.framework.user.entity.User;

/**
 * 修订人信息
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/22
 */
public class UserAuditorAware implements AuditorAware<String> {

  @Override
  public String getCurrentAuditor() {
    User user = AccountContext.currentUser();
    return user.getUsername();
  }
}
