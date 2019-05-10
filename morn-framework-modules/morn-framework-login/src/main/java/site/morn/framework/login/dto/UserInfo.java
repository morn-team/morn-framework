package site.morn.framework.login.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import site.morn.framework.user.entity.User;

/**
 * 用户信息
 *
 * @author timely-rain
 * @since 1.0.0, 2019/1/17
 */
@AllArgsConstructor
@Getter
@Setter
public class UserInfo {

  /**
   * 用户信息
   */
  private User user;

  /**
   * 权限码
   */
  private List<String> privileges;
}
