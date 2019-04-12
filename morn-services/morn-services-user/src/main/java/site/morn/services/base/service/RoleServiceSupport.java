package site.morn.services.base.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import site.morn.boot.support.CrudServiceSupport;
import site.morn.core.CriteriaMap;
import site.morn.services.base.domain.Role;
import site.morn.services.base.repository.RoleRepository;

/**
 * 角色服务实现
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/9
 */
@Service
public class RoleServiceSupport extends CrudServiceSupport<Role, Long, RoleRepository> implements
    RoleService {

  @Override
  protected Specification<Role> searchSpecification(Role model, CriteriaMap attach) {
    return null;
  }
}
