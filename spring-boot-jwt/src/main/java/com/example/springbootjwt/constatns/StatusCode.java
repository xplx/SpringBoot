package com.example.springbootjwt.constatns;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-16
 * Time: 11:07
 */
public class StatusCode {
    public static final int OK=200;
    public static final int FAILED=100;

    public static final int BAD_REQUEST=400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUNT = 404;

    public static final int MICRO_SERVICE_UNAVAILABLE = 40001;//微服务不可用

    public static final int SERVER_ERROR=500;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE=503;
}
