package site.morn.framework.context;

import site.morn.framework.context.function.CurrentProducer;
import site.morn.framework.entity.BaseUser;

/**
 * 当前用户适配器
 *
 * @author timely-rain
 * @since 1.0.0, 2019/4/16
 */
public interface CurrentUserProducer<T extends BaseUser> extends CurrentProducer<T> {

  /**
   * 获取当前用户名
   */
  String getCurrentUsername();
}
