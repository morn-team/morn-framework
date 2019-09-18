package site.morn.framework.user.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import site.morn.boot.data.jpa.JpaRepository;
import site.morn.framework.user.entity.Role;

/**
 * 角色Restful数据访问对象
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/10
 * @since 1.0-SNAPSHOT
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  /**
   * 查询用户所属角色
   *
   * @param id 用户编号
   * @return 用户所属角色
   */
  List<Role> findAllByUsersId(Long id);
}
