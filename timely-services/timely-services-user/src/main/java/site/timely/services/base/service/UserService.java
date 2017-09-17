package site.timely.services.base.service;


import site.timely.services.base.domain.User;

/**
 * 用户服务
 */
public interface UserService extends JpaService<User, Long> {
    User findByUsername(String username);

    void deleteByUsername(String username);
}
