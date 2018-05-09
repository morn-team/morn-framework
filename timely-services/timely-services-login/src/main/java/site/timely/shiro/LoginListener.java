package site.timely.shiro;

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
 * @verion 1.0.0, 2017/10/12
 * @since 1.0-SNAPSHOT
 */
@Component
public class LoginListener implements AuthenticationListener {
    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
        System.out.println("LoginListener.onSuccess");
    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        System.out.println("LoginListener.onFailure");
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        System.out.println("LoginListener.onLogout");
    }
}
