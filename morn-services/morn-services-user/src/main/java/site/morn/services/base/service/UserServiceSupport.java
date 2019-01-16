package site.morn.services.base.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.morn.boot.jpa.SpecificationBuilder;
import site.morn.boot.support.CrudServiceSupport;
import site.morn.core.CriteriaMap;
import site.morn.services.base.domain.User;
import site.morn.services.base.repository.UserRepository;

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
    return repository.findByUsername(username);
  }

  @Override
  public void deleteByUsername(String username) {
    repository.deleteByUsername(username);
  }

  @Override
  public List<String> getPrivilegeCodes(User user) {

    List<String> list = new ArrayList<>();
//        if (ConstantUtils.isAdmin(user.getUsername()))
//        {
//            list = privilegeService.getAllCodes();
//        }
//        else
//        {
//            user = userDao.findOne(user.getId());
//            Set<Role> roles = user.getRoles();
//            for (Role role : roles)
//            {
//                Set<Privilege> privileges = role.getPrivileges();
//                for (Privilege privilege : privileges)
//                {
//                    list.add(privilege.getPrivilegeCode());
//                }
//            }
//        }

    return list;
  }

  @Override
  protected Specification<User> searchSpecification(User model, CriteriaMap attach) {
    return SpecificationBuilder
        .specification((root, criteriaQuery, criteriaBuilder, jpaRestrain) -> {

        });
  }
}


