package site.morn.framework.context;

import java.util.List;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import site.morn.bean.BeanCaches;
import site.morn.framework.entity.BaseUser;

/**
 * 账户上下文
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/17
 */
@Slf4j
@UtilityClass
public class AccountContext {

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  @SuppressWarnings("unchecked")
  public static <T extends BaseUser> T currentUser() {
    List<CurrentUserAdapter> adapters = BeanCaches.beans(CurrentUserAdapter.class);
    Assert.notEmpty(adapters, "无法获取当前用户适配器");
    int size = adapters.size();
    if (size > 1) {
      log.warn("存在多个当前用户适配器：{}", size);
    }
    CurrentUserAdapter<T> userAdapter = adapters.get(0);
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
