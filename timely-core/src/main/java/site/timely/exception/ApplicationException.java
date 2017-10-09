package site.timely.exception;

/**
 * 应用异常
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.8
 */
public class ApplicationException extends RuntimeException {

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常级别
     */
    private ExceptionLevel level;

    /**
     * 异常说明
     */
    private String description;

    /**
     * 解决方案
     */
    private String solution;

    public ApplicationException() {
    }

    public ApplicationException(String code, ExceptionLevel level, String description, String solution) {
        this.code = code;
        this.level = level;
        this.description = description;
        this.solution = solution;
    }

    /* Getter And Setter */

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
