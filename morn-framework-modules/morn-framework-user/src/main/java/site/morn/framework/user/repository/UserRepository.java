package site.morn.framework.user.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.morn.boot.data.jpa.JpaRepository;
import site.morn.framework.user.entity.User;

/**
 * 用户数据访问
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/28
 */
@Repository
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
