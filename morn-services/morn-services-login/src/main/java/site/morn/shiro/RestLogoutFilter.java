package site.morn.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import site.morn.boot.web.Responses;
import site.morn.rest.RestBuilders;
import site.morn.rest.RestMessage;

/**
 * Rest登出过滤器
 *
 * @author timely-rain
 * @since 1.0.0, 2018/11/8
 */
@Slf4j
public class RestLogoutFilter extends LogoutFilter {

  @Override
  protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    Subject subject = getSubject(request, response);
    try {
      subject.logout();
    } catch (SessionException ise) {
      log.debug(
          "Encountered session exception during logout.  This can generally safely be ignored.",
          ise);
    }
    RestMessage restMessage = RestBuilders.successMessage();
    Responses.standard(response).respond(restMessage);
    return false;
  }
}
