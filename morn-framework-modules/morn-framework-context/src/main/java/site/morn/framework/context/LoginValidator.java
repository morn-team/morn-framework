package site.morn.framework.context;

import site.morn.core.BeanValidator;
import site.morn.framework.entity.BaseUser;

/**
 * 登录校验
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/12
 */
public interface LoginValidator<T extends BaseUser> extends BeanValidator<T> {

}
