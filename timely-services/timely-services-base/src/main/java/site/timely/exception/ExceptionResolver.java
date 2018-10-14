package site.timely.exception;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.timely.http.HttpResult;
import site.timely.http.HttpResultProvider;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller异常处理
 *
 * @author timely-rain
 * @version 1.0.0, 2017/10/9
 * @since 1.0-SNAPSHOT
 */
@ControllerAdvice
public class ExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @Resource
    protected HttpResultProvider provider;

    @ExceptionHandler
    @ResponseBody
    public HttpResult doResolveException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        return resolveException(request, response, e);
    }

    // JSON convert exception
//    @ExceptionHandler(HttpMessageConversionException.class)
//    @ResponseBody
//    public RestMessage handleHttpMessageConversionException(
//            HttpServletRequest request, HttpServletResponse response, HttpMessageConversionException e) {
//        return Rests.error();
//    }

    /**
     * 基本异常处理
     *
     * @param request  请求
     * @param response 响应
     * @param e        异常
     * @return json
     */
    private HttpResult resolveException(HttpServletRequest request, HttpServletResponse response, Exception e) {

        logger.error("异常[url]:" + request.getRequestURI());
        //如果是业务异常，错误码也记录进日志
        if (e instanceof ApplicationException) {
            ApplicationException exception = (ApplicationException) e;
            Throwable cause = exception.getCause();

            //底层异常为空的时候，不打印过多的日志
            if (cause != null) {
                logger.error("异常[code]:" + exception.getCode(), e);
            } else {
                logger.error("异常[code]:" + exception.getCode() + ",[description]:" + exception.getDescription());
            }
        } else {
            logger.error(e.getMessage(), e);
        }

        // 如果请求为Ajax,则返回错误json,否则交给org.springframework.web.servlet.handler.SimpleMappingExceptionResolver处理
//        if (Servlets.isAjaxRequest(request)) {
        //如果是业务异常
        if (e instanceof HttpException) {
            HttpResult error = provider.exception((HttpException) e);
            return result(error);
        } else if (e instanceof ApplicationException) {
            HttpResult error = provider.exception((ApplicationException) e);
            return result(error);
        } else if (e instanceof AuthenticationException) {
            HttpResult error = provider.error(e, ExceptionConstant.NO_PRIVILEGE);
            return result(error);
        } else if (e instanceof CannotCreateTransactionException) {
            HttpResult error = provider.error(e, ExceptionConstant.DB_NOT_CONNECT);
            return result(error);
        } else {
            HttpResult error = provider.error(e, ExceptionConstant.DEFAULT_CODE);
            return result(error);
        }
//        } else {
//            throw e;
//        }
    }

    /**
     * 结果
     *
     * @param result 网络请求结果
     * @return json
     */
    private HttpResult result(HttpResult result) {
        //设置response状态码Session超时返回401，其它返回500
//        String code = result.getCode();
//        if (ExceptionCode.SESSION_TIMEOUT.equals(code)) {
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        } else if (ExceptionCode.NO_PRIVILEGE.equals(code)) {
//            response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
//        } else if (ExceptionCode.DEFAULT_CODE.equals(code)
//                || ExceptionCode.DB_NOT_CONNECT.equals(code)) {
//            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        }

//        Map<String, Object> msgMap = new HashMap<String, Object>();
//        msgMap.put("success", false);
//        msgMap.put("code", code);
//        msgMap.put("msg", exception.getMessage());
//        msgMap.put("description", exception.getDescription());
//        msgMap.put("solution", exception.getSolution());

//        return JSON.toJSONString(result);
        return result;
    }
}
