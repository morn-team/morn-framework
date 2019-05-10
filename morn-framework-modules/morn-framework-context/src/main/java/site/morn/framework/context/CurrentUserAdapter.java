package site.morn.framework.context;

/**
 * 当前用户适配器
 *
 * @author timely-rain
 * @since 0.0.1-SNAPSHOT, 2019/4/16
 */
public interface CurrentUserAdapter<T> {

  /**
   * 获取当前用户
   *
   * @return 当前用户
   */
  T getCurrentUser();
}
