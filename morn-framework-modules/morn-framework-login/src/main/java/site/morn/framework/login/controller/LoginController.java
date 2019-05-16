package site.morn.framework.login.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.framework.context.AccountContext;
import site.morn.framework.login.info.LoginInfo;
import site.morn.framework.user.entity.User;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;

/**
 * 登录控制器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/28
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping
public class LoginController {

  /**
   * 登录由FormAuthenticationFilter代理
   */
  @PostMapping("/login")
  public RestMessage login(@Valid @RequestBody User user, HttpServletRequest request) {
    Object token = request.getSession().getAttribute("token");
    Map<String, Object> data = new HashMap<>();
    data.put("token", token);
    return RestBuilders.successMessage(data);
  }

  @GetMapping("/login/info")
  public RestMessage loginInfo() {
    LoginInfo loginInfo = AccountContext.loginInfo();
    return RestBuilders.successMessage(loginInfo);
  }
}
