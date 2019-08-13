package site.morn.framework.shiro;

import org.apache.shiro.SecurityUtils;
import site.morn.bean.annotation.Tag;
import site.morn.framework.context.CurrentUserProducer;
import site.morn.framework.user.entity.User;
import site.morn.util.TypeUtils;

/**
 * Shiro用户适配器
 *
 * @author timely-rain
 * @since 0.0.1-SNAPSHOT, 2019/4/16
 */
@Tag
public class ShiroUserProducer implements CurrentUserProducer<User> {

  @Override
  public User getCurrentUser() {
    Object principal = SecurityUtils.getSubject().getPrincipal();
    return TypeUtils.cast(principal);
  }
}
