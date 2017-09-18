package site.timely.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import site.timely.services.base.domain.User;
import site.timely.services.base.service.UserService;

import javax.annotation.Resource;

/**
 * site.timely.shiro
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/18
 * @since 1.8
 */
@Component
public class UserRealm extends AuthorizingRealm {

    /**
     * 用户服务
     */
    @Resource
    private UserService userService;

    /**
     * 认证 AuthenticationInfo 认证信息
     *
     * @param authenticationToken 认证令牌
     * @return 认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 查询用户
        User user = userService.findByUsername(token.getUsername());
        return createAuthenticationInfo(user);
    }

    /**
     * 授权
     *
     * @param principals principals
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        return null;
    }


    /**
     * 创建认证信息
     *
     * @param user 数据库取出来的用户信息
     * @return AuthenticationInfo 认证信息
     */
    private AuthenticationInfo createAuthenticationInfo(User user) {
        // 用用户名当做盐来加密
        ByteSource salt = ByteSource.Util.bytes(ByteSource.Util.bytes(user.getUsername()));
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());
        return info;
    }

}
