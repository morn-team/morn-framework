package site.morn.http;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import site.morn.exception.ApplicationException;
import site.morn.exception.HttpException;
import site.morn.exception.HttpExceptionBody;
import site.morn.exception.HttpExceptionBodyProvider;

/**
 * 网络请求结果提供者
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/29
 * @since 1.0-SNAPSHOT
 */
@Component
public class HttpResultProvider {

  /**
   * 成功
   */
  private static final String SUCCESS = "http.success";

  /**
   * 失败
   */
  private static final String FAIL = "http.fail";

  @Resource
  private HttpExceptionBodyProvider provider;

  /**
   * 成功
   *
   * @return HttpResult
   */
  public HttpResult success() {
    return this.success(SUCCESS);
  }

  /**
   * 成功
   *
   * @param code 错误码
   * @param params 参数
   * @return HttpResult
   */
  public HttpResult success(String code, String... params) {
    HttpExceptionBody info = provider.info(code, params);
    return this.result(true, info, null, null);
  }

  /**
   * 失败
   *
   * @return HttpResult
   */
  public HttpResult fail() {
    return this.fail(FAIL);
  }

  /**
   * 失败
   *
   * @param code 错误码
   * @param params 参数
   * @return HttpResult
   */
  public HttpResult fail(String code, String... params) {
    HttpExceptionBody warning = provider.warning(code, params);
    return this.result(false, warning, null, null);
  }


  /**
   * 失败
   *
   * @param code 错误码
   * @param params 参数
   * @return HttpResult
   */
  public HttpResult error(Exception exception, String code, String... params) {
    HttpExceptionBody warning = provider.error(exception, code, params);
    return this.result(false, warning, null, null);
  }

  /**
   * 异常
   *
   * @param exception 异常
   * @return HttpResult
   */
  public HttpResult exception(ApplicationException exception) {
    HttpExceptionBody exceptionBody = new HttpExceptionBody();
    exceptionBody.setAdapter(exception);
    return this.result(false, exceptionBody, null, null);
  }

  /**
   * 异常
   *
   * @param exception 异常
   * @return HttpResult
   */
  public HttpResult exception(HttpException exception) {
    return this.result(false, exception.getBody(), null, null);
  }

  /**
   * 结果
   *
   * @param isSuccess 是否成功
   * @param notify 应答信息
   * @param data 数据
   * @param attach 补充数据
   * @return HttpResult
   */
  private HttpResult result(boolean isSuccess, HttpExceptionBody notify, String data,
      String attach) {
    HttpResult result = new HttpResult(isSuccess, notify);
    result.setData(data);
    result.setAttach(attach);
    return result;
  }
}
