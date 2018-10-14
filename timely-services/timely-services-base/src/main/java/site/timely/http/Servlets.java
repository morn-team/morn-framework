package site.timely.http;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * site.timely.services.base.http
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/9
 * @since 1.0-SNAPSHOT
 */
public class Servlets {

  /**
   * 从线程变量（ThreadLocal）中获取当前请求的HttpServletRequest对象
   */
  public static HttpServletRequest getCurrentRequest() {
    ServletRequestAttributes attrs =
        ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes());
    if (attrs == null) {
      return null;
    }
    return attrs.getRequest();
  }

  /**
   * 判断是否是ajax请求
   */
  public static boolean isAjaxRequest(HttpServletRequest request) {
    return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
  }
}
