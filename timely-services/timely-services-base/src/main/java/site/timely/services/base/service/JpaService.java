package site.timely.services.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * JPA基础服务
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.0-SNAPSHOT
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
}
