package site.morn.framework.context.function;

import site.morn.core.BeanProducer;

/**
 * 获取当前信息
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/4
 */
@FunctionalInterface
public interface CurrentProducer<T> extends BeanProducer<T> {

  /**
   * 获取当前信息
   */
  T getCurrent();

  @Override
  default T product() {
    return getCurrent();
  }
}
