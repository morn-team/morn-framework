package site.timely.services.base.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import site.timely.services.base.domain.User;

/**
 * 用户Restful数据访问对象
 *
 * @author TianGanLin
 * @version 1.0.0, 2017/9/9
 * @since 1.0-SNAPSHOT
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 按用户名查询
     *
     * @param username 用户名
     * @return 用户
     */
    User findByUsername(String username);

    /**
     * 按用户名删除
     *
     * @param username 用户名
     */
    @Modifying
    @Query("delete from User where username = :username")
    void deleteByUsername(@Param("username") String username);
}