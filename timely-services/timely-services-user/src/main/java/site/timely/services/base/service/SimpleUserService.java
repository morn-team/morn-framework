package site.timely.services.base.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.timely.services.base.domain.User;
import site.timely.services.base.repository.JpaRepository;
import site.timely.services.base.repository.UserRepository;

import javax.annotation.Resource;


@Service
@Transactional
public class SimpleUserService
        extends SimpleJpaService<User, Long, UserRepository> implements UserService {

    @Resource
    private UserRepository repository;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        repository.deleteByUsername(username);
    }
}
