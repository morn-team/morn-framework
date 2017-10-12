package site.timely.services.base.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.timely.services.base.domain.User;
import site.timely.services.base.repository.JpaRepository;
import site.timely.services.base.repository.UserRepository;
import site.timely.util.ConstantUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class SimpleUserService
        extends SimpleJpaService<User, Long, UserRepository> implements UserService {

    @Override
    public User findByUsername(String username) {
        return dao().findByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        dao().deleteByUsername(username);
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
}


