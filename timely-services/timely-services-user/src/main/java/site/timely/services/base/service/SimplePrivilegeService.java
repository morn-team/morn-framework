package site.timely.services.base.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import site.timely.services.base.domain.Privilege;
import site.timely.services.base.domain.Role;
import site.timely.services.base.domain.User;
import site.timely.services.base.repository.PrivilegeRepository;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限服务实现
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/18
 * @since 1.8
 */
@Service
public class SimplePrivilegeService extends SimpleJpaService<Privilege, Long, PrivilegeRepository> implements PrivilegeService {
    @Override
    public List<String> findCodes(User user) {
        Specification<Privilege> specification = (root, query, cb) -> {
            Join<Privilege, Role> roles = root.join("roles");
            Predicate equal = cb.equal(roles.get("creator"), user.getUsername());
            return cb.and(equal);
        };
        List<Privilege> all = dao().findAll(specification);
        return all.stream().map(Privilege::getCode).collect(Collectors.toList());
    }
}
