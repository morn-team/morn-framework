package site.timely.services.base.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.timely.services.base.domain.User;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author TianGanLin
 * @version 1.0.0, 2017/9/9
 * @since 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave () {
        User user = new User();
        user.setUsername("timely-test");
        user.setPassword("timely-test");
        userRepository.save(user);
    }

}