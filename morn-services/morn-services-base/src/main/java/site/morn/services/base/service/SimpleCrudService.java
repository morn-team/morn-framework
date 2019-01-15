package site.morn.services.base.service;

import java.io.Serializable;
import javax.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.condition.ConditionSpecification;
import site.morn.boot.rest.RestPage;
import site.morn.core.CriteriaMap;
import site.morn.services.base.repository.BaseRepository;

/**
 * 增查改删服务实现
 *
 * @author timely-rain
 * @version 1.0.0, 2018/10/14
 * @since 1.0
 */
@Slf4j
@Getter
@Deprecated
public class SimpleCrudService<T, ID extends Serializable, D extends BaseRepository<T, ID>> implements
    CrudService<T, ID> {

  /**
   * 数据访问对象
   */
  private final D dao;

  public SimpleCrudService(D dao) {
    this.dao = dao;
  }

  @Override
  public <S extends T> S add(S entity) {
    return null;
  }

  @Override
  public Page<T> search(RestPage<T> restPage) {
    log.info("搜索列表");
    PageRequest pageRequest = restPage.generatePageRequest();// 分页请求
    CriteriaMap attach = restPage.getAttach(); // 附加数据
    T model = restPage.getModel(); // 数据模型
    ConditionSpecification<T> specification = specification(attach, model); // 查询条件
    return dao.findAll(model, pageRequest, specification); // 分页查询
  }

  @Override
  public <S extends T> S update(S entity) {
    return null;
  }

  @Override
  public <S extends T> S patch(S entity) {
    return null;
  }

  @Override
  public void delete(ID id) {

  }

  @Override
  public <S extends T> void delete(S entity) {

  }

  @Override
  public void delete(Iterable<? extends ID> ids) {

  }

  /**
   * JPA查询条件
   *
   * @return JPA查询条件
   */
  protected ConditionSpecification<T> specification(CriteriaMap attach, T model) {
    return ((root, query, cb, jc) -> {
      // 默认匹配所有字段
      Predicate[] equals = jc.equals();
      jc.clauseAnd(equals);
    });
  }
}
