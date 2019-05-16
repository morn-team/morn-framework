package site.morn.framework.context;

import site.morn.core.BeanProducer;
import site.morn.framework.entity.BaseUser;

/**
 * 当前用户适配器
 *
 * @author timely-rain
 * @since 0.0.1-SNAPSHOT, 2019/4/16
 */
@FunctionalInterface
public interface CurrentUserAdapter<T extends BaseUser> extends BeanProducer<T> {

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  T getCurrentUser();

  @Override
  default T product() {
    return getCurrentUser();
  }
}
