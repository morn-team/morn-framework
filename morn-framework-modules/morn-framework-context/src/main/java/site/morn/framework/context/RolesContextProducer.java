package site.morn.framework.context;

import java.util.Collection;
import site.morn.framework.context.function.CurrentProducer;
import site.morn.framework.entity.BaseRole;

/**
 * 当前角色生产者
 *
 * @author timely-rain
 * @since 1.2.1, 2019/9/12
 */
public interface RolesContextProducer<T extends BaseRole> extends CurrentProducer<Collection<T>> {

}
