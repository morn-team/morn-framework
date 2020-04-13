package site.morn.framework.context.function;

/**
 * 获取激活信息
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/4
 */
public interface ActiveProducer<T> extends CurrentProducer<T> {

  /**
   * 获取激活信息
   */
  T getActive();

  @Override
  default T product() {
    return getActive();
  }
}
