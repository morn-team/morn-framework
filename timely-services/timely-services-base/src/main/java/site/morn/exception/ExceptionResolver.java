package site.morn.exception;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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

  private final ExceptionProcessor exceptionProcessor;

  @Autowired
  public ExceptionResolver(ExceptionProcessor exceptionProcessor) {
    this.exceptionProcessor = exceptionProcessor;
  }

  @ExceptionHandler
  @ResponseBody
  public RestMessage doResolveException(HttpServletRequest request, HttpServletResponse response,
      Exception e) {
    ExceptionMessage exceptionMessage = exceptionProcessor.process(e);
    if (Objects.isNull(exceptionMessage)) {
      return Rests.error();
    }
    if (StringUtils.isEmpty(exceptionMessage.getCode())) {
      exceptionMessage.setCode(Rests.CODE_ERROR);
    }
    return Rests.error().code(exceptionMessage.getCode()).message(exceptionMessage.getMessage());
  }
}
