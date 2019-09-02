package site.morn.framework.context.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import site.morn.framework.entity.BaseDepartment;
import site.morn.framework.entity.BasePrivilege;
import site.morn.framework.entity.BaseRole;
import site.morn.framework.entity.BaseUser;

/**
 * 登录信息
 *
 * @author timely-rain
 * @since 1.2.0, 2019/5/16
 */
@Data
public class BaseLoginInfo implements Serializable {

  /**
   * @serialField
   */
  private static final long serialVersionUID = 1L;

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
  private List<? extends BaseRole> roles;

  /**
   * 拥有权限
   */
  private List<? extends BasePrivilege> privileges;

  /**
   * 获取权限码
   *
   * @return 权限码集合
   */
  public List<String> getPrivilegeCodes() {
    return privileges.stream().map(BasePrivilege::getCode).collect(Collectors.toList());
  }
}
