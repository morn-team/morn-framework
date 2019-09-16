package site.morn.framework.context.function;

import java.util.Collection;

/**
 * 获取当前信息
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/16
 */
@FunctionalInterface
public interface CurrentCollectionProducer<T> extends CurrentProducer<Collection<T>> {

  /**
   * 获取当前信息
   */
  Collection<T> getCurrent();

  @Override
  default Collection<T> product() {
    return getCurrent();
  }
}
