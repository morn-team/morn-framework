package site.timely.http;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * HttpResult提供者
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/29
 * @since 1.8
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
    private HttpNotifyProvider provider;

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
        HttpNotify info = provider.info(code, params);
        return result(true, info, null, null);
    }

    /**
     * 成功
     *
     * @return HttpResult
     */
    public HttpResult fail() {
        return success(FAIL);
    }

    /**
     * 失败
     *
     * @param code   错误码
     * @param params 参数
     * @return HttpResult
     */
    public HttpResult fail(String code, String... params) {
        HttpNotify info = provider.warning(code, params);
        return result(false, info, null, null);
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
    public HttpResult result(boolean isSuccess, HttpNotify notify, String data, String attach) {
        HttpResult result = new HttpResult(isSuccess, notify);
        result.setData(data);
        result.setAttach(attach);
        return result;
    }
}
