package site.morn.shiro;

import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpStatus;
import site.morn.rest.Rests;

/**
 * REST鉴权过滤器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/15
 * @since 1.0
 */
@Slf4j
public class RestAuthenticationFilter extends FormAuthenticationFilter {

  @Override
  protected void issueSuccessRedirect(ServletRequest request, ServletResponse response)
      throws Exception {
    String s = JSONObject.toJSONString(Rests.ok());
    response.getWriter().write(s);
  }

  /**
   * 拒绝访问
   *
   * @param request 请求
   * @param response 响应
   * @return 是否
   * @throws Exception 登录异常
   */
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws Exception {
    if (isLoginRequest(request, response)) {
      if (isLoginSubmission(request, response)) {
        if (log.isTraceEnabled()) {
          log.trace("Login submission detected.  Attempting to execute login.");
        }
        return executeLogin(request, response);
      } else {
        if (log.isTraceEnabled()) {
          log.trace("Login page view.");
        }
        return true;
      }
    } else {
      if (log.isTraceEnabled()) {
        log.trace("Attempting to access a path which requires authentication.  Forwarding to the "
            + "Authentication url [" + getLoginUrl() + "]");
      }
      HttpServletResponse resp = (HttpServletResponse) response;
      resp.setStatus(HttpStatus.UNAUTHORIZED.value());
      return false;
    }
  }
}
