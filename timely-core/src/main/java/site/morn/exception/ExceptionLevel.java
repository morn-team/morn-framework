package site.morn.exception;

/**
 * 异常级别
 *
 * @author timely-rain
 * @version 1.0.0, 2017/9/29
 * @since 1.0-SNAPSHOT
 */
public enum ExceptionLevel {
  /**
   * 提示
   */
  Info("info"),

  /**
   * 警告
   */
  Warning("warning"),
  /**
   * 错误
   */
  Error("error");

  public static final String INFO = "info";
  public static final String WARNING = "warning";
  public static final String ERROR = "error";

  private String name;

  ExceptionLevel(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
