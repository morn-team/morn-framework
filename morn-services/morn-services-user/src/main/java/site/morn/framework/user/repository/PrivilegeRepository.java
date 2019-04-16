package site.morn.framework.user.repository;

import org.springframework.stereotype.Repository;
import site.morn.boot.support.JpaRepository;
import site.morn.framework.user.entity.Privilege;

/**
 * 权限库
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

}
