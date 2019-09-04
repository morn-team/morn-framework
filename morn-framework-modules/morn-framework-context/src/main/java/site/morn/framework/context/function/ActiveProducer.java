package site.morn.framework.context.function;

import site.morn.core.BeanProducer;

/**
 * 获取激活信息
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/4
 */
public interface ActiveProducer<T> extends BeanProducer<T> {

  /**
   * 获取激活信息
   */
  T getActive();

  @Override
  default T product() {
    return getActive();
  }
}
