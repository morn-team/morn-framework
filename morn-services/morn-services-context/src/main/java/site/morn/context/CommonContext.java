package site.morn.context;

import java.util.Objects;
import lombok.experimental.UtilityClass;
import org.apache.shiro.SecurityUtils;
import site.morn.application.user.User;
import site.morn.util.TypeUtils;

/**
 * 通用上下文
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/17
 */
@UtilityClass
public class CommonContext {

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  public static User currentUser() {
    Object principal = SecurityUtils.getSubject().getPrincipal();
    return TypeUtils.as(principal);
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
