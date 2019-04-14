package site.morn.services.base.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.application.user.User;
import site.morn.boot.support.CrudControllerSupport;
import site.morn.context.CommonContext;
import site.morn.rest.RestBuilder;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;
import site.morn.services.base.service.PrivilegeService;
import site.morn.services.base.service.UserService;
import site.morn.services.user.UserConstant.Data;

/**
 * 用户控制器
 *
 * @author timely-rain
 * @since 1.0.0, 2017/9/28
 */
@RestController
@RequestMapping("/user")
public class UserController extends CrudControllerSupport<User, Long, UserService> {

  /**
   * 权限服务
   */
  @Resource
  private PrivilegeService privilegeService;

  /**
   * 获取用户信息
   *
   * @return 用户信息
   */
  @GetMapping("info")
  public RestMessage info() {
    // 当前登录用户
    User user = CommonContext.currentUser();
    // 权限码
    List<String> codes = privilegeService.findCodes(user);
    codes.add("admin"); // 管理员权限
    // 构建REST消息
    RestBuilder builder = RestBuilders.successBuilder()
        .data(Data.INFO, user)
        .data(Data.PRIVILEGES, codes);
    return builder.build();
  }
}
