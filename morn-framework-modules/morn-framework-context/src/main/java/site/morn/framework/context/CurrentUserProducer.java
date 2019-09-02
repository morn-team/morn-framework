package site.morn.framework.context;

import site.morn.core.BeanProducer;
import site.morn.framework.entity.BaseUser;

/**
 * 当前用户适配器
 *
 * @author timely-rain
 * @since 1.0.0, 2019/4/16
 */
public interface CurrentUserProducer<T extends BaseUser> extends BeanProducer<T> {

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  T getCurrentUser();

  /**
   * 获取当前用户名
   */
  String getCurrentUsername();

  @Override
  default T product() {
    return getCurrentUser();
  }
}
