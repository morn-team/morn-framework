package site.morn.framework.context;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.Assert;
import site.morn.framework.entity.BaseUser;

/**
 * 修订人信息
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/22
 */
public class UserAuditorAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    BaseUser user = AccountContext.currentUser();
    Assert.notNull(user, "无法获取当前用户");
    return Optional.ofNullable(user.getUsername());
  }
}
