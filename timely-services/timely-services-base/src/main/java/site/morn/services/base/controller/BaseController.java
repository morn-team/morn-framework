package site.morn.services.base.controller;

import javax.annotation.Resource;
import site.morn.exception.HttpExceptionProvider;
import site.morn.http.HttpResultProvider;

/**
 * 基础控制器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/11
 * @since 1.0-SNAPSHOT
 */
public class BaseController {

  /**
   * 网络请求结果提供者
   */
  @Resource
  protected HttpResultProvider provider;
  /**
   * 网络异常提供者
   */
  @Resource
  protected HttpExceptionProvider exceptionProvider;
}
