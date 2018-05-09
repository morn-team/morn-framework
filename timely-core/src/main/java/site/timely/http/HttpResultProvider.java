package site.timely.http;

import org.springframework.stereotype.Component;
import site.timely.exception.ApplicationException;
import site.timely.exception.HttpException;
import site.timely.exception.HttpExceptionBody;
import site.timely.exception.HttpExceptionBodyProvider;

import javax.annotation.Resource;

/**
 * 网络请求结果提供者
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/29
 * @since 1.0-SNAPSHOT
 */
@Component
public class HttpResultProvider {

    /**
     * 成功
     */
    private static final String SUCCESS = "http.success";

    /**
     * 失败
     */
    private static final String FAIL = "http.fail";

    @Resource
    private HttpExceptionBodyProvider provider;

    /**
     * 成功
     *
     * @return HttpResult
     */
    public HttpResult success() {
        return success(SUCCESS);
    }

    /**
     * 成功
     *
     * @param code   错误码
     * @param params 参数
     * @return HttpResult
     */
    public HttpResult success(String code, String... params) {
        HttpExceptionBody info = provider.info(code, params);
        return result(true, info, null, null);
    }

    /**
     * 失败
     *
     * @return HttpResult
     */
    public HttpResult fail() {
        return fail(FAIL);
    }

    /**
     * 失败
     *
     * @param code   错误码
     * @param params 参数
     * @return HttpResult
     */
    public HttpResult fail(String code, String... params) {
        HttpExceptionBody warning = provider.warning(code, params);
        return result(false, warning, null, null);
    }


    /**
     * 失败
     *
     * @param code   错误码
     * @param params 参数
     * @return HttpResult
     */
    public HttpResult error(Exception exception, String code, String... params) {
        HttpExceptionBody warning = provider.error(exception, code, params);
        return result(false, warning, null, null);
    }

    /**
     * 异常
     *
     * @param exception 异常
     * @return HttpResult
     */
    public HttpResult exception(ApplicationException exception) {
        return new HttpResult(false, exception.getBody());
    }

    /**
     * 异常
     *
     * @param exception 异常
     * @return HttpResult
     */
    public HttpResult exception(HttpException exception) {
        return new HttpResult(false, exception.getBody());
    }

    /**
     * 结果
     *
     * @param isSuccess 是否成功
     * @param notify    应答信息
     * @param data      数据
     * @param attach    补充数据
     * @return HttpResult
     */
    public HttpResult result(boolean isSuccess, HttpExceptionBody notify, String data, String attach) {
        HttpResult result = new HttpResult(isSuccess, notify);
        result.setData(data);
        result.setAttach(attach);
        return result;
    }
}
