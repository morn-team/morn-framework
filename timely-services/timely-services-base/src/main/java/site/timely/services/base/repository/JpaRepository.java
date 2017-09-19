package site.timely.services.base.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.condition.ConditionSpecification;
import org.springframework.data.jpa.condition.JpaConditionUtils;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Jpa基础数据访问
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.8
 */
@NoRepositoryBean
public interface JpaRepository<T, ID extends Serializable>
        extends org.springframework.data.jpa.repository.JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /* ConditionSpecification Queries Start */

    /**
     * 判断对象是否存在
     *
     * @param specification JPA Condition 查询规格
     * @return 对象是否存在
     */
    default boolean exists(T model, ConditionSpecification<T>... specification) {
        return findAll(model, specification).size() > 0;
    }

    /**
     * 查询单个实体
     *
     * @param model          实体数据
     * @param specifications JPA Condition 查询规格
     * @return Entity
     * @see ConditionSpecification
     * @see JpaSpecificationExecutor
     */
    default T findOne(T model, ConditionSpecification<T>... specifications) {
        return this.findOne(
                JpaConditionUtils.specification(model, specifications));
    }

    /**
     * 查询多个实体
     *
     * @param model          实体数据
     * @param specifications JPA Condition 查询规格
     * @return List<Entity>
     * @see ConditionSpecification
     * @see JpaSpecificationExecutor
     */
    default List<T> findAll(T model, ConditionSpecification<T>... specifications) {
        return this.findAll(
                JpaConditionUtils.specification(model, specifications));
    }

    /**
     * 查询多个实体
     *
     * @param model          实体数据
     * @param specifications JPA Condition 查询规格
     * @param sort           排序
     * @return List<Entity>
     * @see ConditionSpecification
     * @see JpaSpecificationExecutor
     */
    default List<T> findAll(T model, Sort sort, ConditionSpecification<T>... specifications) {
        return this.findAll(
                JpaConditionUtils.specification(model, specifications), sort);
    }

    /**
     * 查询多个实体
     *
     * @param model          实体数据
     * @param specifications JPA Condition 查询规格
     * @param pageable       分页
     * @return List<Entity>
     * @see ConditionSpecification
     * @see JpaSpecificationExecutor
     */
    default Page<T> findAll(T model, Pageable pageable, ConditionSpecification<T>... specifications) {
        return this.findAll(
                JpaConditionUtils.specification(model, specifications), pageable);
    }

    /* ConditionSpecification Queries End */
}
