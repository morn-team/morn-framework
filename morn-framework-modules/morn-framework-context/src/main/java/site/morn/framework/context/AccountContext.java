package site.morn.framework.context;

import static site.morn.framework.context.CommonConstant.Caches.ACCOUNT_GROUP;

import java.util.Collection;
import java.util.Objects;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import site.morn.bean.BeanCaches;
import site.morn.cache.CacheGroup;
import site.morn.cache.CacheGroups;
import site.morn.framework.context.dto.BaseLoginInfo;
import site.morn.framework.context.function.ActiveProducer;
import site.morn.framework.context.function.CurrentProducer;
import site.morn.framework.entity.BaseDepartment;
import site.morn.framework.entity.BaseUser;
import site.morn.util.BeanFunctionUtils;
import site.morn.util.TypeUtils;

/**
 * 账户上下文
 *
 * <p>提供当前登录用户的相关操作
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/17
 */
@Slf4j
@UtilityClass
public class AccountContext {

  /**
   * 获取自定义登录信息
   *
   * @param target 信息类
   * @param <T> 信息类型
   * @return 自定义登录信息
   */
  @SuppressWarnings("unchecked")
  public static <T> T active(Class<T> target) {
    ActiveProducer<T> activeProducer = BeanCaches.targetBean(ActiveProducer.class, target);
    Assert.notNull(activeProducer, "无法获取激活登录信息");
    return activeProducer.getActive();
  }

  /**
   * 获取当前激活的组织机构
   *
   * @param <T> 组织机构类型
   * @return 当前激活的组织机构
   */
  @SuppressWarnings("unchecked")
  public static <T extends BaseDepartment> T activeDepartment() {
    DepartmentProducer<T> producer = BeanCaches.bean(DepartmentProducer.class);
    Assert.notNull(producer, "无法获取激活组织机构");
    return producer.getActive();
  }

  /**
   * 获取账户缓存组
   *
   * @return 账户缓存组
   */
  public static CacheGroup cacheGroup() {
    return CacheGroups.cacheGroup(ACCOUNT_GROUP);
  }

  /**
   * 获取自定义登录信息
   *
   * @param target 信息类
   * @param <T> 信息类型
   * @return 自定义登录信息
   */
  @SuppressWarnings("unchecked")
  public static <T> T current(Class<T> target) {
    CurrentProducer<T> producer = BeanCaches.targetBean(CurrentProducer.class, target);
    Assert.notNull(producer, "无法获取当前登录信息");
    return producer.getCurrent();
  }

  /**
   * 获取当前组织机构
   *
   * @param <T> 组织机构类型
   * @return 当前组织机构
   */
  @SuppressWarnings("unchecked")
  public static <T extends BaseDepartment> T currentDepartment() {
    DepartmentProducer<T> producer = BeanCaches.bean(DepartmentProducer.class);
    Assert.notNull(producer, "无法获取当前组织机构");
    return producer.getCurrent();
  }

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  @SuppressWarnings("unchecked")
  public static <T extends BaseUser> T currentUser() {
    CurrentUserProducer<T> producer = BeanCaches.bean(CurrentUserProducer.class);
    Assert.notNull(producer, "无法获取当前用户适配器");
    return producer.getCurrent();
  }

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  public static String currentUsername() {
    CurrentUserProducer<?> producer = BeanCaches.bean(CurrentUserProducer.class);
    Assert.notNull(producer, "无法获取当前用户适配器");
    return producer.getCurrentUsername();
  }

  /**
   * 获取当前用户系统权限码
   */
  public static Collection<String> currentPrivilegeCodes() {
    PrivilegeProducer<?> producer = BeanCaches.bean(PrivilegeProducer.class);
    Assert.notNull(producer, "无法获取系统权限适配器");
    return producer.getPrivileges();
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
    return TypeUtils.cast(product);
  }

  /**
   * 判断当前用户是否为管理员
   *
   * @return 当前用户是否为管理员
   */
  public static boolean isAdmin() {
    return isAdmin(currentUser());
  }

  /**
   * 判断用户是否为管理员
   *
   * @param user 用户
   * @return 用户是否为管理员
   */
  public static boolean isAdmin(BaseUser user) {
    return Objects.equals(user.getUsername(), CommonConstant.ADMIN);
  }
}
