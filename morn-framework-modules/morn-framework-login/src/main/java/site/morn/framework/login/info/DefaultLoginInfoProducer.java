package site.morn.framework.login.info;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import site.morn.bean.annotation.Tag;
import site.morn.framework.context.AccountContext;
import site.morn.framework.context.LoginInfoProducer;
import site.morn.framework.user.entity.Role;
import site.morn.framework.user.entity.User;
import site.morn.framework.user.service.RoleService;

/**
 * 默认登录信息
 *
 * @author timely-rain
 * @since 2.1.0, 2019/5/16
 */
@Component
@Tag
public class DefaultLoginInfoProducer implements LoginInfoProducer<LoginInfo> {

  @Resource
  private RoleService roleService;

  @Override
  public LoginInfo product() {
    User user = AccountContext.currentUser();
    List<Role> roles = roleService.roles(user);

    LoginInfo loginInfo = new LoginInfo();
    loginInfo.setDepartment(null);
    loginInfo.setUser(user);
    loginInfo.setRoles(roles.stream().collect(Collectors.toList()));
    loginInfo.setPrivileges(Collections.emptyList());

    return loginInfo;
  }
}
