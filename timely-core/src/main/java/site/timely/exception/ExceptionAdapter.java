package site.timely.exception;

/**
 * 应用异常适配器
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/10/10
 * @since 1.8
 */
public interface ExceptionAdapter {

    String getCode();

    void setCode(String code);

    ExceptionLevel getLevel();

    void setLevel(ExceptionLevel level);

    String getDescription();

    void setDescription(String description);

    String getSolution();

    void setSolution(String solution);

    default ExceptionAdapter setAdapter(ExceptionAdapter adapter) {
        setCode(adapter.getCode());
        setLevel(adapter.getLevel());
        setDescription(adapter.getDescription());
        setSolution(adapter.getSolution());
        return this;
    }
}
