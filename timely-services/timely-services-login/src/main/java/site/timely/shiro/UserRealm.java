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
import java.util.Objects;

/**
 * site.timely.shiro
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/18
 * @since 1.0-SNAPSHOT
 */
@Component
public class UserRealm extends AuthorizingRealm {

    /**
     * 用户服务
     */
    @Resource
    private UserService userService;

//    /**
//     * 权限服务
//     */
//    @Resource
//    @Lazy
//    private PrivilegeService privilegeService;

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
        if (Objects.isNull(user)) throw new UnknownAccountException();
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
//        User user = (User) principals.getPrimaryPrincipal();
//        List<Privilege> all = privilegeService.findAll(user);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        for (Privilege privilege : all) {
//            info.addStringPermission(privilege.getCode());
//        }
        return null; // 不需要Shiro验证权限
    }


    /**
     * 创建认证信息
     *
     * @param user 数据库取出来的用户信息
     * @return AuthenticationInfo 认证信息
     */
    private AuthenticationInfo createAuthenticationInfo(User user) {
        // 将用户名当做盐来加密
        ByteSource salt = ByteSource.Util.bytes(ByteSource.Util.bytes(user.getUsername()));
        return new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());
    }

}
