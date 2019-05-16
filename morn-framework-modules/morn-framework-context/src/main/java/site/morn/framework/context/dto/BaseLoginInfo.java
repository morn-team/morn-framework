package site.morn.framework.context.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import site.morn.framework.entity.BaseDepartment;
import site.morn.framework.entity.BaseRole;
import site.morn.framework.entity.BaseUser;

/**
 * 登录信息
 *
 * @author timely-rain
 * @since 2.1.0, 2019/5/16
 */
@Data
public class BaseLoginInfo implements Serializable {

  /**
   * 登录用户
   */
  private BaseUser user;

  /**
   * 所属机构
   */
  private BaseDepartment department;

  /**
   * 所属角色
   */
  private List<BaseRole> roles;

  /**
   * 权限码
   */
  private List<String> privileges;
}
