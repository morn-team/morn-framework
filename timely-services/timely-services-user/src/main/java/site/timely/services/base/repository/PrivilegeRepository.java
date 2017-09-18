package site.timely.services.base.repository;

import org.springframework.data.repository.NoRepositoryBean;
import site.timely.services.base.domain.Privilege;

/**
 * 权限库
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/18
 * @since 1.8
 */
@NoRepositoryBean
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
