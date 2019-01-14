package site.morn.services.base.service;

import java.io.Serializable;
import org.springframework.data.domain.Page;
import site.morn.boot.rest.RestPage;

/**
 * 增查改删服务
 *
 * @author timely-rain
 * @version 1.0.0, 2018/10/14
 * @since 1.0
 */
@Deprecated
public interface CrudService<T, ID extends Serializable> {

  /**
   * 新增
   *
   * @param entity 瞬态对象
   * @param <S> 实体类型
   * @return 持久化对象
   */
  <S extends T> S add(S entity);

  /**
   * 查询
   *
   * @param restPage REST分页请求
   * @return 分页结果集
   */
  Page<T> search(RestPage<T> restPage);

  /**
   * 全量更新
   *
   * @param entity 瞬态对象
   * @param <S> 实体类型
   * @return 持久化对象
   */
  <S extends T> S update(S entity);

  /**
   * 增量更新
   *
   * @param entity 瞬态对象
   * @param <S> 实体类型
   * @return 持久化对象
   */
  <S extends T> S patch(S entity);

  /**
   * 删除
   *
   * @param id 主键
   */
  void delete(ID id);

  /**
   * 删除
   *
   * @param entity 瞬态对象
   */
  <S extends T> void delete(S entity);

  /**
   * 批量删除
   *
   * @param ids 主键集合
   */
  void delete(Iterable<? extends ID> ids);
}
