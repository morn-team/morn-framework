package site.morn.context;

import java.util.Objects;
import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;
import site.morn.application.user.User;
import site.morn.bean.BeanCaches;

/**
 * 账户上下文
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/17
 */
@UtilityClass
public class AccountContext {

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  public static User currentUser() {
    CurrentUserAdapter<User> userAdapter = BeanCaches.bean(CurrentUserAdapter.class, User.class);
    Assert.notNull(userAdapter, "无法获取当前用户适配器");
    return userAdapter.getCurrentUser();
  }

  /**
   * 判断当前用户是否为管理员
   *
   * @return 当前用户是否为管理员
   */
  public static boolean isAdmin() {
    return Objects.equals(currentUser().getUsername(), CommonConstant.ADMIN);
  }
}
