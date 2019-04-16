package site.morn.shiro;

import org.apache.shiro.SecurityUtils;
import site.morn.application.user.User;
import site.morn.context.CurrentUserAdapter;
import site.morn.util.TypeUtils;

/**
 * Shiro用户适配器
 *
 * @author timely-rain
 * @since 0.0.1-SNAPSHOT, 2019/4/16
 */
public class ShiroUserAdapter implements CurrentUserAdapter<User> {

  @Override
  public User getCurrentUser() {
    Object principal = SecurityUtils.getSubject().getPrincipal();
    return TypeUtils.as(principal);
  }
}
