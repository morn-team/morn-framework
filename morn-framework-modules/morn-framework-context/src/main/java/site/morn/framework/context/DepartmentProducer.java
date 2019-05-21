package site.morn.framework.context;

import site.morn.core.BeanProducer;
import site.morn.framework.entity.BaseDepartment;

/**
 * 当前组织机构
 *
 * @author TianGanLin
 * @since 0.1.1, 2019/5/21
 */
public interface DepartmentProducer<T extends BaseDepartment> extends BeanProducer<BaseDepartment> {

  @Override
  default BaseDepartment product() {
    return getActiveDepartment();
  }

  /**
   * 获取当前激活的组织机构
   *
   * @return 当前激活的组织机构
   */
  T getActiveDepartment();

  /**
   * 获取当前组织机构
   *
   * @return 当前组织机构
   */
  T getDepartment();
}
