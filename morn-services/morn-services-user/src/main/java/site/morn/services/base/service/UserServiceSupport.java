package site.morn.services.base.service;

import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import site.morn.application.user.User;
import site.morn.application.user.User.Fields;
import site.morn.boot.jpa.JpaConditionUtils;
import site.morn.boot.jpa.SpecificationBuilder;
import site.morn.boot.support.CrudServiceSupport;
import site.morn.context.CommonContext;
import site.morn.core.CriteriaMap;
import site.morn.services.base.repository.UserRepository;
import site.morn.services.user.UserConstant.Attach;

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
    return SpecificationBuilder.specification((root, query, builder, predicate) -> {
      User currentUser = CommonContext.currentUser(); // 当前登录用户
      // 过滤当前用户
      Predicate filterCurrent = builder
          .notEqual(root.get(Fields.username), currentUser.getUsername());
      // 按用户名/姓名模糊搜索
      Object keyword = attach.get(Attach.KEYWORD);
      if (!StringUtils.isEmpty(keyword)) {
        Predicate containsUsername = builder
            .like(root.get(Fields.username), JpaConditionUtils.contains(keyword));
        Predicate containsNickname = builder
            .like(root.get(Fields.nickname), JpaConditionUtils.contains(keyword));
        Predicate containsKeyword = builder.or(containsUsername, containsNickname);
        predicate.applyAnd(containsKeyword);
      }
      predicate.applyAnd(filterCurrent);
    });
//    return SpecificationBuilder.withParameter(model, attach)
//        .specification((reference, predicate, condition) -> {
//          Root<?> root = reference.root();
//          CriteriaBuilder builder = reference.builder();
//          User currentUser = ContextHolder.currentUser(); // 当前登录用户
//          // 过滤当前用户
//          Predicate filterCurrent = builder
//              .notEqual(root.get(UserField.USERNAME), currentUser.getUsername());
//          predicate.applyAnd(filterCurrent);
//        });
  }
}


