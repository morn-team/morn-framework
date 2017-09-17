package site.timely.services.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * JPA基础服务
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.8
 */
public interface JpaService<T, ID extends Serializable> {

    /* 基础 Crud Start */

    <S extends T> S save(S entity);

    T findOne(ID id);

    boolean exists(ID id);

    long count();

    void delete(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    /* 基础 Crud End */

    /**
     * 查询一个实体,并判断实体是否存在
     *
     * @param id 主键
     * @return 实体类
     * @apiNote
     */
    T pullOne(ID id);

    /**
     * 更新,并判断实体是否存在
     *
     * @param id       主键
     * @param function 更新Lambda
     * @return 实体类
     * @apiNote before:获取entity -> function -> after:保存entity
     */
    T update(ID id, Function<T, T> function);

    /**
     * 删除,并判断实体是否存在
     *
     * @param id       主键
     * @param consumer 删除Lambda
     * @apiNote before:获取entity -> consumer -> after:删除entity
     */
    void delete(ID id, Consumer<T> consumer);
}
