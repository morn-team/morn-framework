package site.timely.http;

import site.timely.exception.ApplicationException;
import site.timely.exception.ExceptionLevel;

/**
 * Http应答
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/29
 * @since 1.8
 */
public class HttpNotify extends ApplicationException {

    /**
     * 标题
     */
    private String title;

    public HttpNotify(String code, ExceptionLevel level, String title, String description, String solution) {
        super(code, level, description, solution);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
