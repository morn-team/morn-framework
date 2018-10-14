package site.timely.exception;

/**
 * 网络异常内容
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/9
 * @since 1.0-SNAPSHOT
 */
public class HttpExceptionBody extends ExceptionBody implements HttpExceptionAdapter {

  /**
   * 标题
   */
  private String title;

  public HttpExceptionBody() {
  }

  public HttpExceptionBody(String code, ExceptionLevel level, String title, String description,
      String solution) {
    super(code, level, description, solution);
    this.title = title;
  }

  public HttpExceptionBody(Exception exception, String code, ExceptionLevel level, String title,
      String description, String solution) {
    super(exception, code, level, description, solution);
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
