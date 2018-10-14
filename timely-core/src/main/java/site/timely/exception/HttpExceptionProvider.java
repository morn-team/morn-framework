package site.timely.exception;

import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 网络异常提供者
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/29
 * @since 1.0-SNAPSHOT
 */
@Component
public class HttpExceptionProvider {

  @Resource
  private HttpExceptionBodyProvider provider;

  /**
   * 提示
   *
   * @param code 错误码
   * @param params 描述参数
   * @return 网络异常
   */
  public HttpException info(String code, String... params) {
    return instance(code, ExceptionLevel.Info, params);
  }

  /**
   * 警告
   *
   * @param code 错误码
   * @param params 描述参数
   * @return 网络异常
   */
  public HttpException warning(String code, String... params) {
    return instance(code, ExceptionLevel.Warning, params);
  }

  /**
   * 错误
   *
   * @param code 错误码
   * @param params 描述参数
   * @return 网络异常
   */
  public HttpException error(String code, String... params) {
    return instance(code, ExceptionLevel.Error, params);
  }

  /**
   * 错误
   *
   * @param exception 异常
   * @param params 描述参数
   * @return 网络异常
   */
  public HttpException error(Exception exception, String... params) {
    return instance(exception, exception.getClass().getSimpleName(), ExceptionLevel.Error, params);
  }

  /**
   * 实例
   *
   * @param code 异常码
   * @param level 异常级别
   * @param params 参数
   * @return 网络异常
   */
  private HttpException instance(String code, ExceptionLevel level, String... params) {
    return instance(null, code, level, params);
  }

  /**
   * 实例
   *
   * @param exception 异常
   * @param code 异常码
   * @param level 异常级别
   * @param params 参数
   * @return 网络异常
   */
  private HttpException instance(Exception exception, String code, ExceptionLevel level,
      String... params) {
    HttpException httpException =
        Objects.isNull(exception) ? new HttpException() : new HttpException(exception.getMessage());
    HttpExceptionBody exceptionBody = provider.instance(exception, code, level, params);
    httpException.setBody(exceptionBody);
    return httpException;
  }
}
