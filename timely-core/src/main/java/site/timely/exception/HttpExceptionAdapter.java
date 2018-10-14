package site.timely.exception;

/**
 * 网络异常适配器
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/10
 * @since 1.0-SNAPSHOT
 */
public interface HttpExceptionAdapter extends ExceptionAdapter {

  String getTitle();

  void setTitle(String title);

  default HttpExceptionAdapter setAdapter(HttpExceptionAdapter adapter) {
    setCode(adapter.getCode());
    setLevel(adapter.getLevel());
    setTitle(adapter.getTitle());
    setDescription(adapter.getDescription());
    setSolution(adapter.getSolution());
    return this;
  }
}
