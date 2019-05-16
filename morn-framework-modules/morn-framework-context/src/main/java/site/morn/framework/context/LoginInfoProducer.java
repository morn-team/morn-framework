package site.morn.framework.context;

import site.morn.core.BeanProducer;
import site.morn.framework.context.dto.BaseLoginInfo;

/**
 * 登录信息生产者
 *
 * @author timely-rain
 * @since 2.1.0, 2019/5/16
 */
@FunctionalInterface
public interface LoginInfoProducer<T extends BaseLoginInfo> extends BeanProducer<T> {

}
