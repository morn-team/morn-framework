package site.morn.services.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.boot.rest.RestPage;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;
import site.morn.services.base.domain.User;
import site.morn.services.base.service.PrivilegeService;
import site.morn.services.base.service.UserService;

/**
 * 用户控制器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/28
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  /**
   * 权限服务
   */
  private final PrivilegeService privilegeService;

  @Autowired
  public UserController(UserService userService, PrivilegeService privilegeService) {
    this.userService = userService;
    this.privilegeService = privilegeService;
  }

  @PostMapping
  public RestMessage add(@Validated @RequestBody User user) {
    return RestBuilders.successMessage();
  }

  /**
   * 获取用户信息
   *
   * @return 用户信息
   */
  @GetMapping("info")
  public RestMessage info() {
    User user = (User) SecurityUtils.getSubject().getPrincipal();
    List<String> codes = privilegeService.findCodes(user);
    Map<String, Object> data = new HashMap<>();
    codes.add("admin");
    data.put("privileges", codes);
    return RestBuilders.successMessage(data);
  }

  @PostMapping("datatable")
  public RestMessage datatable(RestPage<User> restPage) {
    Page<User> page = userService.search(restPage);
    return RestBuilders.successMessage(page);
  }
}
