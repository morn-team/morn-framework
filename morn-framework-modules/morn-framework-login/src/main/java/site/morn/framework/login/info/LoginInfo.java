package site.morn.framework.login.info;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import site.morn.framework.context.dto.BaseLoginInfo;
import site.morn.framework.entity.BaseDepartment;
import site.morn.framework.user.entity.User;

/**
 * site.morn.framework.login.info
 *
 * @author timely-rain
 * @since 1.0.0, 2019/5/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
public class LoginInfo extends BaseLoginInfo {

  /**
   * @serialField
   */
  private static final long serialVersionUID = 1L;

  /**
   * 登录用户
   */
  private User user;

  /**
   * 所属机构
   */
  private BaseDepartment department;
}
