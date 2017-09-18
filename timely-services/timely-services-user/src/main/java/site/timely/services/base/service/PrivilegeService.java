package site.timely.services.base.service;

import site.timely.services.base.domain.Privilege;
import site.timely.services.base.domain.User;

import java.util.List;

/**
 * 权限服务
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/18
 * @since 1.8
 */
public interface PrivilegeService extends JpaService<Privilege, Long> {
    /**
     * 查询用户权限码
     *
     * @param user 用户
     * @return 权限集合
     */
    List<String> findCodes(User user);
}
