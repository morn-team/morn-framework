package site.morn.framework.user.service;

import java.util.List;
import site.morn.boot.support.CrudService;
import site.morn.framework.user.entity.Privilege;
import site.morn.framework.user.entity.User;

/**
 * 权限服务
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
public interface PrivilegeService extends CrudService<Privilege, Long> {

  /**
   * 查询用户权限码
   *
   * @param user 用户
   * @return 权限集合
   */
  List<String> findCodes(User user);

  List<Privilege> findAll(User user);
}
