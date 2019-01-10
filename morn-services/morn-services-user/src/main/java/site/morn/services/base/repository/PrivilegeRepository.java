package site.morn.services.base.repository;

import org.springframework.stereotype.Repository;
import site.morn.services.base.domain.Privilege;

/**
 * 权限库
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
@Repository
public interface PrivilegeRepository extends BaseRepository<Privilege, Long> {

}
