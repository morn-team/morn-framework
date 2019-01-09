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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.morn.boot.rest.RestPage;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;
import site.morn.services.base.domain.User;
import site.morn.services.base.service.PrivilegeService;
import site.morn.services.base.service.RoleService;
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
public class UserController extends BaseController<UserService> {

  @Autowired
  private RoleService roleService;

  /**
   * 权限服务
   */
  @Autowired
  private PrivilegeService privilegeService;

  public UserController(UserService service) {
    super(service);
  }

  @PostMapping
  public Object add(@Validated User user) {
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            List<String> messages = new ArrayList<>();
//            for (FieldError fieldError : fieldErrors) {
//                String message = messageSource.getMessage(fieldError, messageHolder.currentLocale());
//                String fieldPath = fieldError.getObjectName() + "." + fieldError.getField();
//                String fieldName = messageSource.getMessage(fieldPath, null, fieldPath, messageHolder.currentLocale());
//                messages.add(fieldName + message);
//            }
//            String s = StringUtils.collectionToCommaDelimitedString(messages);
//            return Rests.error().message(s);
//        }
    return new HashMap<>();
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
    data.put("roles", codes);
    return RestBuilders.successMessage(data);
  }

  @PostMapping("datatable")
  public RestMessage datatable(RestPage<User> restPage) {
    Page<User> page = getService().search(restPage);
    return RestBuilders.successMessage(page);
  }
}
