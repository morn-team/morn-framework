package site.morn.framework.context;

import java.util.Objects;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import site.morn.bean.BeanCaches;
import site.morn.framework.context.dto.BaseLoginInfo;
import site.morn.framework.entity.BaseUser;
import site.morn.util.BeanFunctionUtils;
import site.morn.util.TypeUtils;

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
    CurrentUserAdapter<T> userAdapter = BeanCaches.tagBean(CurrentUserAdapter.class);
    Assert.notNull(userAdapter, "无法获取当前用户适配器");
    return userAdapter.getCurrentUser();
  }

  /**
   * 获取登录信息
   *
   * @param <T> 登录信息类型
   * @return 登录信息
   */
  @SuppressWarnings("unchecked")
  public static <T extends BaseLoginInfo> T loginInfo() {
    Object product = BeanFunctionUtils.product(LoginInfoProducer.class);
    return TypeUtils.as(product);
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
