package site.morn.framework.context;

import lombok.experimental.UtilityClass;

/**
 * 通用常量
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/17
 */
@UtilityClass
public class CommonConstant {

  /**
   * 管理员账号
   */
  public static final String ADMIN = "admin";

  /**
   * 上下文常量
   */
  @UtilityClass
  public class Context {

    /**
     * 激活的组织机构
     */
    public static final String ACTIVE_DEPARTMENT = "activeDepartment";
  }
}
