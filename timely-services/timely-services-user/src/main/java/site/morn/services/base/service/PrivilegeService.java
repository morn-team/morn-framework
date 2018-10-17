package site.morn.services.base.service;

import java.util.List;
import site.morn.services.base.domain.Privilege;
import site.morn.services.base.domain.User;

/**
 * 权限服务
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
public interface PrivilegeService extends JpaService<Privilege, Long> {

  /**
   * 查询用户权限码
   *
   * @param user 用户
   * @return 权限集合
   */
  List<String> findCodes(User user);

  List<Privilege> findAll(User user);
}
