package site.morn.services.base.service;


import site.morn.application.user.User;
import site.morn.boot.support.CrudService;

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
