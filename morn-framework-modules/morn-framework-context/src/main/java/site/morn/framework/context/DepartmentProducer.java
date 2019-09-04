package site.morn.framework.context;

import site.morn.framework.context.function.ActiveProducer;
import site.morn.framework.context.function.CurrentProducer;
import site.morn.framework.entity.BaseDepartment;
import site.morn.framework.entity.BaseUser;

/**
 * 当前组织机构
 *
 * @author TianGanLin
 * @since 0.1.1, 2019/5/21
 */
public interface DepartmentProducer<T extends BaseDepartment> extends ActiveProducer<T>,
    CurrentProducer<T> {

  /**
   * 获取组织机构
   *
   * @param id 组织机构编号
   * @return 组织机构
   */
  T get(Long id);

  /**
   * 获取当前组织机构
   */
  @Override
  default T getCurrent() {
    BaseUser baseUser = AccountContext.currentUser();
    return get(baseUser.getDepartmentId());
  }

  @Override
  default T product() {
    return getActive();
  }
}
