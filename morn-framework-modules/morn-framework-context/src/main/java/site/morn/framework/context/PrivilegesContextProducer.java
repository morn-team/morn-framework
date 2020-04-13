package site.morn.framework.context;

import java.util.Collection;
import site.morn.framework.context.function.CurrentProducer;
import site.morn.framework.entity.BasePrivilege;

/**
 * 系统权限生产者
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/10
 */
public interface PrivilegesContextProducer<T extends BasePrivilege> extends
    CurrentProducer<Collection<T>> {

  /**
   * 获取权限码
   */
  Collection<String> getPrivileges();
}
