package site.morn.services.base.service;

import org.springframework.stereotype.Service;
import site.morn.services.base.domain.Role;
import site.morn.services.base.repository.RoleRepository;

/**
 * 角色服务实现
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/9
 */
@Service
public class SimpleRoleService extends SimpleCrudService<Role, Long, RoleRepository> implements
    RoleService {

  public SimpleRoleService(RoleRepository dao) {
    super(dao);
  }
}
