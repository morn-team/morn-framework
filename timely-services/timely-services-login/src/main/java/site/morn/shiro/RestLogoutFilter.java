package site.morn.shiro;

import com.alibaba.fastjson.JSONObject;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import site.morn.rest.Rests;
import site.morn.util.HttpUtils.ContentType;

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
    String s = JSONObject.toJSONString(Rests.ok());
    response.setContentType(ContentType.JSON);
    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    response.getWriter().write(s);
    return false;
  }
}
