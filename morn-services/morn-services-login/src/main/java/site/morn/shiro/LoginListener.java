package site.morn.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * 登录监听器
 *
 * @author timely-rain
 * @since 1.0.0, 2017/10/12
 */
@Component
@Slf4j
public class LoginListener implements AuthenticationListener {

  @Override
  public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
    log.info("LoginListener.onSuccess");
  }

  @Override
  public void onFailure(AuthenticationToken token, AuthenticationException ae) {
    log.info("LoginListener.onFailure");
  }

  @Override
  public void onLogout(PrincipalCollection principals) {
    log.info("LoginListener.onLogout");
  }
}
