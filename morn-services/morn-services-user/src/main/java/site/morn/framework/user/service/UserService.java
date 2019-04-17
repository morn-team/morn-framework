package site.morn.framework.user.service;


import site.morn.boot.support.CrudService;
import site.morn.framework.user.entity.User;

/**
 * 用户服务
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/28
 */
public interface UserService extends CrudService<User, Long> {

  User findByUsername(String username);

  void deleteByUsername(String username);

}
