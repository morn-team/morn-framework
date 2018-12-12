package site.morn.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.morn.rest.RestMessage;
import site.morn.rest.Rests;

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
    response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
    return Rests.error().message(e.getMessage());
  }
}
