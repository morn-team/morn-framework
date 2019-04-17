package site.morn.framework.exception;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;

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
    log.error("应用异常：" + e.toString(), e);
    String message = Optional.ofNullable(e.getMessage()).orElse(e.toString());
    RestMessage restMessage = RestBuilders.failureMessage();
    restMessage.setMessage(restMessage.getMessage() + " - " + message);
    return restMessage;
  }
}
