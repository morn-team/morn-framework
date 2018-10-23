package site.morn.services.base.service;


import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.morn.services.base.repository.BaseRepository;

/**
 * site.timely.services.base.service
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/16
 * @since 1.0-SNAPSHOT
 */
@Deprecated
public class SimpleJpaService<T, ID extends Serializable, D extends BaseRepository<T, ID>> implements
    JpaService<T, ID> {

  /**
   * 数据访问对象
   */
  @Autowired
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
    {
      throw new RuntimeException("主键不能为空");
    }
    T one = dao.findOne(id);
    if (one == null) // 记录已删除
    {
      throw new RuntimeException("记录已删除");
    }
//            throw exceptionFactory.createException(ExceptionCode.RECORD_DELETE);
    return one;
  }


  /**
   * 更新,并判断实体是否存在
   *
   * @param id 主键
   * @param function 更新Lambda
   * @return 实体类
   * @implNote protected service
   * @apiNote before:获取entity -> function -> after:保存entity
   */
  protected T update(ID id, Function<T, T> function) {
    T one = pullOne(id);
    T apply = function.apply(one);
    return dao.save(apply);
  }

  /**
   * 删除,并判断实体是否存在
   *
   * @param id 主键
   * @param consumer 删除Lambda
   * @implNote protected service
   * @apiNote before:获取entity -> consumer -> after:删除entity
   */
  protected void delete(ID id, Consumer<T> consumer) {
    T one = pullOne(id);
    consumer.accept(one);
    dao.delete(id);
  }
}
