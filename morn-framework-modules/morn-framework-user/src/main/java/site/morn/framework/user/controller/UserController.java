package site.morn.framework.user.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.boot.data.CrudControllerSupport;
import site.morn.framework.context.AccountContext;
import site.morn.framework.user.constant.UserConstant.Data;
import site.morn.framework.user.entity.User;
import site.morn.framework.user.service.PrivilegeService;
import site.morn.framework.user.service.UserService;
import site.morn.rest.RestBuilder;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;

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
    User user = AccountContext.currentUser();
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
