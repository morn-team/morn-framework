package site.morn.services.user;

import lombok.experimental.UtilityClass;

/**
 * 用户属性
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/20
 */
@UtilityClass
public class UserConstant {

  /**
   * 附加数据
   */
  @UtilityClass
  public class Attach {

    /**
     * 关键字
     */
    public static final String KEYWORD = "keyword";
  }

  /**
   * 数据
   */
  @UtilityClass
  public class Data {

    /**
     * 用户信息
     */
    public static final String INFO = "info";
    /**
     * 权限码
     */
    public static final String PRIVILEGES = "privileges";
  }

}
