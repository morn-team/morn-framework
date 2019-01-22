package site.morn.services.base.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.application.user.User;
import site.morn.boot.support.CrudControllerSupport;
import site.morn.context.ContextHolder;
import site.morn.rest.RestBuilder;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;
import site.morn.rest.RestModel;
import site.morn.services.base.service.PrivilegeService;
import site.morn.services.base.service.UserService;
import site.morn.services.user.UserConstant;
import site.morn.validate.group.Put;
import site.morn.validate.group.Update;

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
   * 修改
   */
  @PutMapping
  @Override
  public RestMessage update(
      @Validated({Update.class, Put.class}) @RequestBody RestModel<User> restModel) {
    User user = service().update(restModel);
    return RestBuilders.successMessage(user);
  }

  /**
   * 获取用户信息
   *
   * @return 用户信息
   */
  @GetMapping("info")
  public RestMessage info() {
    // 当前登录用户
    User user = ContextHolder.currentUser();
    // 权限码
    List<String> codes = privilegeService.findCodes(user);
    codes.add("admin"); // 管理员权限
    // 构建REST消息
    RestBuilder builder = RestBuilders.successBuilder()
        .data(UserConstant.INFO, user)
        .data(UserConstant.PRIVILEGES, codes);
    return builder.build();
  }
}
