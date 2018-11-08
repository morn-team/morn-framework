package site.morn.shiro;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import site.morn.rest.Rests;
import site.morn.util.HttpUtils.ContentType;

/**
 * REST鉴权过滤器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/15
 * @since 1.0
 */
@Slf4j
public class RestLoginFilter extends FormAuthenticationFilter {

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

  /**
   * 创建令牌
   */
  @Override
  protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
    String contentType = request.getContentType();
    if (!StringUtils.isEmpty(contentType) && contentType.contains(ContentType.JSON)) {
      return createJsonToken(request);
    }
    return super.createToken(request, response);
  }

  /**
   * 登录成功
   */
  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
      ServletRequest request, ServletResponse response) throws Exception {
    String s = JSONObject.toJSONString(Rests.ok());
    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    response.getWriter().write(s);
    return super.onLoginSuccess(token, subject, request, response);
  }

  /**
   * 登录失败
   */
  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
      ServletRequest request, ServletResponse response) {
    String s = JSONObject.toJSONString(Rests.error());
    try {
      response.setCharacterEncoding(StandardCharsets.UTF_8.name());
      response.getWriter().write(s);
    } catch (IOException exception) {
      log.error(e.getMessage(), e);
    }
    return false;
  }

  /**
   * 创建用户令牌
   *
   * @param request 请求
   * @return 用户令牌
   */
  private UsernamePasswordToken createJsonToken(ServletRequest request) {
    try {
      StringBuilder builder = new StringBuilder();
      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
      String s;
      while ((s = bufferedReader.readLine()) != null) {
        builder.append(s);
      }
      return JSONObject.parseObject(builder.toString(),
          UsernamePasswordToken.class);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
    return null;
  }
}
