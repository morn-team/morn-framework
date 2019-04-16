package site.morn.services.base.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.morn.application.user.User;
import site.morn.application.user.User.Fields;
import site.morn.boot.jpa.JpaConditionUtils;
import site.morn.boot.jpa.SpecificationBuilder;
import site.morn.boot.support.CrudServiceSupport;
import site.morn.context.AccountContext;
import site.morn.core.CriteriaMap;
import site.morn.services.base.repository.UserRepository;
import site.morn.services.user.UserConstant.Attach;
import site.morn.util.ArrayUtils;

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
    return SpecificationBuilder.withParameter(model, attach)
        .specification((reference, predicate, condition) -> {
          Root<?> root = reference.root();
          CriteriaBuilder builder = reference.builder();
          User currentUser = AccountContext.currentUser(); // 当前登录用户
          // 过滤当前用户
          Predicate filterCurrent = JpaConditionUtils
              .predicate(root.get(Fields.username), currentUser.getUsername(), builder::equal);
          // 按用户名/姓名模糊搜索
          String[] searchAttributes = ArrayUtils.merge(Fields.username, Fields.nickname);
          Predicate[] containsKeyword = condition.contains(searchAttributes, Attach.KEYWORD);
          predicate.applyAnd(filterCurrent, predicate.mergeAnd(containsKeyword));
        });
  }
}


