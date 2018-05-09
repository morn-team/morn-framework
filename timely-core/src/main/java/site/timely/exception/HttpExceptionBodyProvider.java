package site.timely.exception;

import org.springframework.stereotype.Component;
import site.timely.message.MessageHolder;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 网络异常内容提供者
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/29
 * @since 1.0-SNAPSHOT
 */
@Component
public class HttpExceptionBodyProvider {

    /**
     * 国际化
     */
    @Resource
    private MessageHolder messageHolder;

    /**
     * 提示
     *
     * @param code   错误码
     * @param params 描述参数
     * @return HttpError
     */
    public HttpExceptionBody info(String code, String... params) {
        return instance(code, ExceptionLevel.Info, params);
    }

    /**
     * 警告
     *
     * @param code   错误码
     * @param params 描述参数
     * @return HttpError
     */
    public HttpExceptionBody warning(String code, String... params) {
        return instance(code, ExceptionLevel.Warning, params);
    }

    /**
     * 错误
     *
     * @param code   错误码
     * @param params 描述参数
     * @return HttpError
     */
    public HttpExceptionBody error(String code, String... params) {
        return instance(code, ExceptionLevel.Error, params);
    }

    /**
     * 错误
     *
     * @param code   错误码
     * @param params 描述参数
     * @return HttpError
     */
    public HttpExceptionBody error(Exception exception, String code, String... params) {
        return instance(exception, code, ExceptionLevel.Error, params);
    }

    /**
     * 实例
     *
     * @param code   异常码
     * @param level  异常级别
     * @param params 参数
     * @return 网络异常内容体
     */
    public HttpExceptionBody instance(String code, ExceptionLevel level, String... params) {
        return instance(null, code, level, params);
    }

    /**
     * 实例
     *
     * @param excpetion 异常
     * @param code      异常码
     * @param level     异常级别
     * @param params    参数
     * @return 网络异常内容体
     */
    public HttpExceptionBody instance(Exception excpetion, String code, ExceptionLevel level, String... params) {
        String title = titleMessage(code, level);
        String desc = messageHolder.getMessage(descriptionCode(code), params);
        String solution = messageHolder.getMessage(solutionCode(code));
        return new HttpExceptionBody(excpetion, code, level, title, desc, solution);
    }

    /**
     * 标题
     *
     * @param code 异常码
     * @return 标题
     */
    protected String titleCode(String code) {
        return code + ".title";
    }

    /**
     * 标题
     *
     * @param code 异常码
     * @return 标题
     */
    protected String titleMessage(String code, ExceptionLevel level) {
        code = titleCode(code);
        String message = messageHolder.getMessage(code);
        if (Objects.isNull(message) || Objects.equals(message, code))
            message = messageHolder.getMessage(level.toString());
        return message;
    }

    /**
     * 描述
     *
     * @param code 异常码
     * @return 描述
     */
    protected String descriptionCode(String code) {
        return code + ".desc";
    }

    /**
     * 解决方案
     *
     * @param code 异常码
     * @return 解决方案
     */
    protected String solutionCode(String code) {
        return code + ".solution";
    }
}
