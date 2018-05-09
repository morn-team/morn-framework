package site.timely.services.base.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import site.timely.services.base.domain.Privilege;

import java.util.List;

/**
 * 权限库
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
@NoRepositoryBean
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    /**
     * 所有权限码
     *
     * @param username 用户名
     * @return 权限码集合
     */
    @Query("select code from Privilege where roles.users.username = :username")
    List<String> findCodes(@Param("username") String username);
}
