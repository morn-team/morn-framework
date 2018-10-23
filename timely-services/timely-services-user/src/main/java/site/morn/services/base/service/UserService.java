package site.morn.services.base.service;


import java.util.List;
import site.morn.services.base.domain.User;

/**
 * 用户服务
 */
public interface UserService extends CrudService<User, Long> {

  User findByUsername(String username);

  void deleteByUsername(String username);

  /**
   * 查询所有权限码
   *
   * @param user 用户
   * @return 权限码集合
   */
  List<String> getPrivilegeCodes(User user);

}
