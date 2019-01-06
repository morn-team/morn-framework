package site.morn.services.base.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import site.morn.services.base.domain.Privilege;

/**
 * 权限库
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
//@NoRepositoryBean
@RepositoryRestResource
public interface PrivilegeRepository extends BaseRepository<Privilege, Long> {
//    /**
//     * 所有权限码
//     *
//     * @param username 用户名
//     * @return 权限码集合
//     */
//    @Query("select code from Privilege where roles.users.username = :username")
//    List<String> findCodes(@Param("username") String username);
}
