package site.morn.services.base.service;

import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.morn.application.user.User;
import site.morn.boot.jpa.SpecificationBuilder;
import site.morn.boot.support.CrudServiceSupport;
import site.morn.context.ContextHolder;
import site.morn.core.CriteriaMap;
import site.morn.services.base.repository.UserRepository;
import site.morn.services.user.UserField;

/**
 * 用户服务
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/28
 */
@Service
@Transactional
public class UserServiceSupport extends CrudServiceSupport<User, Long, UserRepository> implements
    UserService {

  @Override
  public User findByUsername(String username) {
    return repository().findByUsername(username);
  }

  @Override
  public void deleteByUsername(String username) {
    repository().deleteByUsername(username);
  }

  @Override
  protected Specification<User> searchSpecification(User model, CriteriaMap attach) {
    return SpecificationBuilder
        .specification((root, query, builder, jpaRestrain) -> {
          User currentUser = ContextHolder.currentUser(); // 当前登录用户
          // 过滤当前用户
          Predicate filterCurrent = builder
              .notEqual(root.get(UserField.USERNAME), currentUser.getUsername());
          jpaRestrain.collector().and(filterCurrent);
        });
  }
}


