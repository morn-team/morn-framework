package site.timely.exception;

import java.util.Objects;

/**
 * 异常内容
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/10/9
 * @since 1.0-SNAPSHOT
 */
public class ExceptionBody implements ExceptionAdapter {
    /**
     * 异常码
     */
    private String code;

    /**
     * 异常级别
     */
    private ExceptionLevel level;

    /**
     * 异常消息
     */
    private String message;

    /**
     * 异常说明
     */
    private String description;

    /**
     * 解决方案
     */
    private String solution;

    public ExceptionBody() {
    }

    public ExceptionBody(ExceptionAdapter adapter) {
        this.setAdapter(adapter);
    }

    public ExceptionBody(String code, ExceptionLevel level, String description, String solution) {
        this.code = code;
        this.level = level;
        this.description = description;
        this.solution = solution;
    }

    public ExceptionBody(Exception exception, String code, ExceptionLevel level, String description, String solution) {
        this(code, level, description, solution);
        if (Objects.nonNull(exception))
            setMessage(exception.getMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ExceptionLevel getLevel() {
        return level;
    }

    public void setLevel(ExceptionLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
