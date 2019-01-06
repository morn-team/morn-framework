package site.morn.services.base.controller;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;
import site.morn.services.base.domain.User;
import site.morn.services.base.service.UserService;

/**
 * 登录控制器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/28
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping
public class LoginController extends BaseController<UserService> {

  public LoginController(UserService service) {
    super(service);
  }

  /**
   * 登录由FormAuthenticationFilter代理
   */
  @PostMapping("/login")
  public RestMessage login(@Valid @RequestBody User user) {
    return RestBuilders.successMessage();
  }
}
