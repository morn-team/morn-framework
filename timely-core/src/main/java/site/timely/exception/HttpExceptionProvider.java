package site.timely.exception;

import org.springframework.stereotype.Component;
import site.timely.message.MessageHolder;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 网络异常提供者
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/29
 * @since 1.8
 */
@Component
public class HttpExceptionProvider {

    @Resource
    private HttpExceptionBodyProvider provider;

    /**
     * 提示
     *
     * @param code   错误码
     * @param params 描述参数
     * @return 网络异常
     */
    public HttpException info(String code, String... params) {
        return instance(code, ExceptionLevel.Info, params);
    }

    /**
     * 警告
     *
     * @param code   错误码
     * @param params 描述参数
     * @return 网络异常
     */
    public HttpException warning(String code, String... params) {
        return instance(code, ExceptionLevel.Warning, params);
    }

    /**
     * 错误
     *
     * @param code   错误码
     * @param params 描述参数
     * @return 网络异常
     */
    public HttpException error(String code, String... params) {
        return instance(code, ExceptionLevel.Error, params);
    }

    /**
     * 异常
     *
     * @param code   错误码
     * @param params 描述参数
     * @return 网络异常
     */
    public HttpException exception(Exception exception, String code, String... params) {
        return instance(exception, code, ExceptionLevel.Error, params);
    }

    /**
     * 实例
     *
     * @param code   异常码
     * @param level  异常级别
     * @param params 参数
     * @return 网络异常
     */
    private HttpException instance(String code, ExceptionLevel level, String... params) {
        return instance(null, code, level, params);
    }

    /**
     * 实例
     *
     * @param exception 异常
     * @param code      异常码
     * @param level     异常级别
     * @param params    参数
     * @return 网络异常
     */
    private HttpException instance(Exception exception, String code, ExceptionLevel level, String... params) {
        HttpException httpException = Objects.isNull(exception) ? new HttpException() : new HttpException(exception.getMessage());
        HttpExceptionBody exceptionBody = provider.instance(exception, code, level, params);
        httpException.setBody(exceptionBody);
        return httpException;
    }
}
