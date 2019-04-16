package site.morn.context;

import org.springframework.data.domain.AuditorAware;
import site.morn.application.user.User;

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
