package site.timely.services.base.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.timely.services.base.domain.User;

import javax.validation.Valid;

/**
 * 登录控制器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/28
 * @since 1.0-SNAPSHOT
 */
@RestController
@RequestMapping
public class LoginController extends BaseController {
    /**
     * 登录由FormAuthenticationFilter代理
     */
    @PostMapping("/login")
    public Object login(@Valid User user) {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
//        try {
//            subject.login(token);
//        } catch (Exception e) {
//            throw exceptionProvider.error(e);
//        }
        return provider.success();
//        return Rests.ok();
    }
}
