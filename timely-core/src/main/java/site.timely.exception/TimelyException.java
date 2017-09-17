package site.timely.exception;

/**
 * Timely(自定义)异常
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/16
 * @since 1.8
 */
public class TimelyException extends RuntimeException {

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常级别
     */
    private String level;

    /**
     * 异常说明
     */
    private String description;

    /**
     * 解决方案
     */
    private String solution;

    /* Getter And Setter */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
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
