package site.morn.framework.user.service;


import java.util.List;
import site.morn.boot.support.CrudService;
import site.morn.framework.user.entity.Role;
import site.morn.framework.user.entity.User;

/**
 * 角色服务
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/9
 */
public interface RoleService extends CrudService<Role, Long> {

  /**
   * 获取用户所属角色
   *
   * @param user 用户
   * @return 用户所属角色
   */
  List<Role> roles(User user);
}
