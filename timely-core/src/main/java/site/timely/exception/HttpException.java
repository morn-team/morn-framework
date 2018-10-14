package site.timely.exception;

/**
 * 网络异常
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/9
 * @since 1.0-SNAPSHOT
 */
public class HttpException extends ApplicationException implements HttpExceptionAdapter {

  /**
   * 网络异常内容
   */
  private HttpExceptionBody body;

  public HttpException() {
  }

  public HttpException(String message) {
    super(message);
  }

  public HttpException(String code, ExceptionLevel level, String title, String description,
      String solution) {
    this.body = new HttpExceptionBody(code, level, title, description, solution);
  }

  @Override
  public HttpExceptionBody getBody() {
    return body;
  }

  public void setBody(HttpExceptionBody body) {
    this.body = body;
  }

  @Override
  public String getTitle() {
    return body.getTitle();
  }

  @Override
  public void setTitle(String title) {
    body.setTitle(title);
  }

  @Override
  public String getCode() {
    return body.getCode();
  }

  @Override
  public void setCode(String code) {
    body.setCode(code);
  }

  @Override
  public ExceptionLevel getLevel() {
    return body.getLevel();
  }

  @Override
  public void setLevel(ExceptionLevel level) {
    body.setLevel(level);
  }

  @Override
  public String getDescription() {
    return body.getDescription();
  }

  @Override
  public void setDescription(String description) {
    body.setDescription(description);
  }

  @Override
  public String getSolution() {
    return body.getSolution();
  }

  @Override
  public void setSolution(String solution) {
    body.setSolution(solution);
  }

  @Override
  public HttpExceptionAdapter setAdapter(HttpExceptionAdapter adapter) {
    return body.setAdapter(adapter);
  }
}
