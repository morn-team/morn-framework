package site.timely.http;

import org.springframework.stereotype.Component;
import site.timely.exception.ExceptionLevel;
import site.timely.message.MessageHolder;

import javax.annotation.Resource;

/**
 * site.timely.http
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/29
 * @since 1.8
 */
@Component
public class HttpNotifyProvider {

    @Resource
    private MessageHolder messageHolder;

    /**
     * 提示
     *
     * @param code   错误码
     * @param params 描述参数
     * @return HttpError
     */
    public HttpNotify info(String code, String... params) {
        return instance(code, ExceptionLevel.Info, params);
    }

    /**
     * 警告
     *
     * @param code   错误码
     * @param params 描述参数
     * @return HttpError
     */
    public HttpNotify warning(String code, String... params) {
        return instance(code, ExceptionLevel.Warning, params);
    }

    /**
     * 错误
     *
     * @param code   错误码
     * @param params 描述参数
     * @return HttpError
     */
    public HttpNotify error(String code, String... params) {
        return instance(code, ExceptionLevel.Error, params);
    }

    public HttpNotify instance(String code, ExceptionLevel level, String... params) {
        String title = messageHolder.getMessage(titleCode(level));
        String desc = messageHolder.getMessage(descriptionCode(code), params);
        String solution = messageHolder.getMessage(solutionCode(code));
        return new HttpNotify(code, level, title, desc, solution);
    }

    /**
     * 标题
     *
     * @param level 异常级别
     * @return 标题
     */
    private String titleCode(ExceptionLevel level) {
        return "error." + level;
    }

    /**
     * 描述
     *
     * @param code 异常码
     * @return 描述
     */
    private String descriptionCode(String code) {
        return "error." + code + ".desc";
    }

    /**
     * 解决方案
     *
     * @param code 异常码
     * @return 解决方案
     */
    private String solutionCode(String code) {
        return "error." + code + ".solution";
    }
}
