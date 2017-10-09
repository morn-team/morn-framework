package site.timely.http;

/**
 * Http结果
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/9/29
 * @since 1.8
 */
public class HttpResult {

    /**
     * Http应答
     */
    private HttpNotify notify;

    /**
     * 是否成功
     */
    private boolean isSuccess;

    /**
     * 数据
     */
    private String data;

    /**
     * 补充数据
     */
    private String attach;

    public HttpResult(boolean isSuccess, HttpNotify notify) {
        this.isSuccess = isSuccess;
        this.notify = notify;
    }

    public HttpNotify getNotify() {
        return notify;
    }

    public void setNotify(HttpNotify notify) {
        this.notify = notify;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
