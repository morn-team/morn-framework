package site.timely.services.base.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.timely.services.base.repository.JpaRepository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * site.timely.services.base.service
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.8
 */
public class SimpleJpaService<T, ID extends Serializable, D extends JpaRepository<T, ID>> implements JpaService<T, ID> {

    /**
     * 数据访问对象
     */
    @Resource
    private D dao;

    public D dao() {
        return dao;
    }

    /* 基础 Crud Start */

    @Override
    public <S extends T> S save(S entity) {
        return dao.save(entity);
    }

    @Override
    public T findOne(ID id) {
        return dao.findOne(id);
    }

    @Override
    public boolean exists(ID id) {
        return dao.exists(id);
    }

    @Override
    public long count() {
        return dao.count();
    }

    @Override
    public void delete(ID id) {
        dao.delete(id);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    /* 基础 Crud End */

    @Override
    public T pullOne(ID id) {
        // TODO 换成国际化异常
        if (id == null) // 主键为空
            throw new RuntimeException("主键不能为空");
        T one = dao.findOne(id);
        if (one == null) // 记录已删除
            throw new RuntimeException("记录已删除");
//            throw exceptionFactory.createException(ExceptionCode.RECORD_DELETE);
        return one;
    }

    @Override
    public T update(ID id, Function<T, T> function) {
        T one = pullOne(id);
        T apply = function.apply(one);
        return dao.save(apply);
    }

    @Override
    public void delete(ID id, Consumer<T> consumer) {
        T one = pullOne(id);
        consumer.accept(one);
        dao.delete(id);
    }
}
