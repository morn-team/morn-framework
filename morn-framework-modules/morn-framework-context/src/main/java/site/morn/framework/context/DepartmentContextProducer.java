package site.morn.framework.context;

import site.morn.framework.context.function.ActiveProducer;
import site.morn.framework.entity.BaseDepartment;

/**
 * 当前组织机构
 *
 * @author TianGanLin
 * @since 0.1.1, 2019/5/21
 */
public interface DepartmentContextProducer<T extends BaseDepartment> extends ActiveProducer<T> {

  /**
   * 获取组织机构
   *
   * @param id 组织机构编号
   * @return 组织机构
   */
  T get(Long id);
}
