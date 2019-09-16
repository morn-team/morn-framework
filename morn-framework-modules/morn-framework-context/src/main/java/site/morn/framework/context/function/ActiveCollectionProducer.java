package site.morn.framework.context.function;

import java.util.Collection;

/**
 * 获取激活信息
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/16
 */
public interface ActiveCollectionProducer<T> extends CurrentProducer<Collection<T>> {

  /**
   * 获取激活信息
   */
  Collection<T> getActive();

  @Override
  default Collection<T> product() {
    return getActive();
  }
}
