package site.morn.framework.user.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import site.morn.boot.support.CrudServiceSupport;
import site.morn.core.CriteriaMap;
import site.morn.framework.entity.BaseUser.Fields;
import site.morn.framework.user.entity.Privilege;
import site.morn.framework.user.entity.Role;
import site.morn.framework.user.entity.User;
import site.morn.framework.user.repository.PrivilegeRepository;

/**
 * 权限服务实现
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
@Service
public class PrivilegeServiceSupport extends
    CrudServiceSupport<Privilege, Long, PrivilegeRepository> implements PrivilegeService {

  @Override
  public List<String> findCodes(User user) {
    List<Privilege> all = findAll(user);
    return all.stream().map(Privilege::getCode).collect(Collectors.toList());
  }

  @Override
  public List<Privilege> findAll(User user) {
    Specification<Privilege> specification = (root, query, cb) -> {
      Join<Privilege, Role> roles = root.join("roles");
      Join<Role, User> users = roles.join("users");
      Predicate equal = cb.equal(users.get(Fields.username), user.getUsername());
      return cb.and(equal);
    };
    return repository().findAll(specification);
  }

  @Override
  protected Specification<Privilege> searchSpecification(Privilege model, CriteriaMap attach) {
    return null;
  }
}
