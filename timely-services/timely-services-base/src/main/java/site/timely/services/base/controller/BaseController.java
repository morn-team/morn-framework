package site.timely.services.base.controller;

import site.timely.exception.HttpExceptionProvider;
import site.timely.http.HttpResultProvider;

import javax.annotation.Resource;

/**
 * 基础控制器
 *
 * @author timely-rain
 * @verion 1.0.0, 2017/10/11
 * @since 1.8
 */
public class BaseController {
    /**
     * 网络请求结果提供者
     */
    @Resource
    protected HttpResultProvider provider;
    /**
     * 网络异常提供者
     */
    @Resource
    protected HttpExceptionProvider exceptionProvider;
}
