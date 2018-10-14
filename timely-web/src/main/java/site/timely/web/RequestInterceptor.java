package site.timely.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * site.timely.web
 *
 * @author timely-rain
 * @version 1.0.0, 2017/11/1
 * @since 1.0-SNAPSHOT
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

  private Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    logger.info("Request:" + request.getRequestURI());
    return super.preHandle(request, response, handler);
  }
}
