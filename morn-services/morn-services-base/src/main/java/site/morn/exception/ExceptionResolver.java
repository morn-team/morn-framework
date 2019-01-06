package site.morn.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;
import site.morn.rest.RestProperties;

/**
 * Controller异常处理
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/9
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@ControllerAdvice
public class ExceptionResolver {

  /**
   * REST配置项
   */
  private final RestProperties restProperties;

  @Autowired
  public ExceptionResolver(RestProperties restProperties) {
    this.restProperties = restProperties;
  }

  /**
   * 解析异常
   *
   * @param request 请求
   * @param response 响应
   * @param e 异常
   * @return REST模型
   */
  @ExceptionHandler
  @ResponseBody
  public RestMessage resolveException(HttpServletRequest request, HttpServletResponse response,
      Exception e) {
    return RestBuilders.errorBuilder().code(restProperties.getFailureCode()).message(e.getMessage())
        .build();
  }
}
