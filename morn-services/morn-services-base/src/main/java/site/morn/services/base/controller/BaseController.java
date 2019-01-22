package site.morn.services.base.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import site.morn.services.base.service.CrudService;

/**
 * 基础控制器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/11
 * @since 1.0-SNAPSHOT
 */
@Deprecated
@Getter
public class BaseController<S extends CrudService> {

  /**
   * 增查改删服务
   */
  private final S service;

  @Autowired
  public BaseController(S service) {
    this.service = service;
  }
}
