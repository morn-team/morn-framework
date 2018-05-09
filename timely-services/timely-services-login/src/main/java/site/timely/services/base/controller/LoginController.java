package site.timely.services.base.controller;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.timely.exception.ExceptionLevel;
import site.timely.http.HttpResult;
import site.timely.services.base.domain.User;

/**
 * 登录控制器
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/28
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping
public class LoginController extends BaseController {
    /**
     * 登录由FormAuthenticationFilter代理
     */
    @PostMapping("/login")
    public HttpResult login(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
        } catch (Exception e) {
            throw exceptionProvider.exception(e, e.getClass().getSimpleName());
        }
        return provider.success();
//        return JSON.toJSONString(provider.success());
    }
}
