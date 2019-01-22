package site.morn.services.base.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用户服务单元测试
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

  private static final String USERNAME = "timely-test";

  @Autowired
  private UserService service;

  @Test
  public void findByUsername() throws Exception {
//    User user = new User();
//    user.setUsername(USERNAME);
//    user.setPassword("timely-test");
//    service.save(user);
//    Assert.assertEquals(service.findByUsername(USERNAME).getUsername(), USERNAME);
  }

  @Test
  public void deleteByUsername() throws Exception {
    service.deleteByUsername(USERNAME);
    Assert.assertNull(service.findByUsername(USERNAME));
  }


}
