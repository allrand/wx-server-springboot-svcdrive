package com.nousunde.wxma.utils;

import org.aspectj.lang.annotation.DeclareError;

public enum StateMsg {
    SC_CONTINUE(100, "continue"),
    SC_SWITCHING_PROTOCOLS(101, "the server is switching protocols according to Upgrade header"),
    SC_OK(200, "the request succeeded normally"),
    SC_CREATED(201, "the request succeeded and created a new resource on the server."),
    SC_ACCEPTED(202, "the request was accepted for processing, but was not completed."),
    SC_NON_AUTHORITATIVE_INFORMATION(203, "the meta information presented by the client did not originate from the server."),
    SC_NO_CONTENT(204, "no new information to return."),
    SC_RESET_CONTENT(205, ""),
    SC_PARTIAL_CONTENT(206, ""),
    SC_MULTIPLE_CHOICES(300, ""),
    SC_MOVED_PERMANENTLY(301, ""),
    SC_MOVED_TEMPORARILY(302, ""),
    SC_SEE_OTHER(303, "the response to the request can be found under a different URI."),
    SC_NOT_MODIFIED(304, "the resource was available and not modified."),
    SC_USE_PROXY(305, ""),
    SC_TEMPORARY_REDIRECT(307, ""),
    SC_BAD_REQUEST(400, ""),
    SC_UNAUTHORIZED(401, ""),
    SC_PAYMENT_REQUIRED(402, ""),
    SC_FORBIDDEN(403, ""),
    SC_NOT_FOUND(404, ""),
    SC_METHOD_NOT_ALLOWED(405, ""),
    SC_NOT_ACCEPTABLE(406, ""),
    SC_PROXY_AUTHENTICATION_REQUIRED(407, ""),
    SC_REQUEST_TIMEOUT(408, ""),
    SC_CONFLICT(409, ""),
    SC_GONE(410, ""),
    SC_LENGTH_REQUIRED(411, ""),
    SC_PRECONDITION_FAILED(412, ""),
    SC_REQUEST_ENTITY_TOO_LARGE(413, ""),
    SC_REQUEST_URI_TOO_LONG(414, ""),
    SC_UNSUPPORTED_MEDIA_TYPE(415, ""),
    SC_REQUESTED_RANGE_NOT_SATISFIABLE(416, ""),
    SC_EXPECTATION_FAILED(417, ""),
    SC_INTERNAL_SERVER_ERROR(500, ""),
    SC_NOT_IMPLEMENTED(501, ""),
    SC_BAD_GATEWAY(502, ""),
    SC_SERVICE_UNAVAILABLE(503, ""),
    SC_GATEWAY_TIMEOUT(504, ""),
    SC_HTTP_VERSION_NOT_SUPPORTED(505, ""),

    AUTH_HAVNT_LOGIN(418, "您可能未登录或登录超时，请先登录."),
    AUTH_HAVNT_PRIVIL(419, "您的帐号没有足够的权限"),
    REQUEST_NOT_EXIST(420, "您请求的页面不存在"),
    REQUEST_PARAM_ERR(421, "您请求的参数错误"),
    REQUEST_RES_DONT_EXIST(422, "您发起的请求方法不能被用于请求相应的资源，请联系管理员A10"),
    REQUEST_DATA_OVERFLOW(423, "您的请求因数据量过大而不被支持，请联系管理员A10"),
    REQUEST_URL_OVERFLOW(424, "您的请求因 URL 过长而不被支持，请联系管理员A10"),
    REQUEST_UNKOWN_ERR(499, "服务器无法理解该请求，请联系管理员A10"),

    SVC_UNSUPPORT(518, "服务端不支持此方法，请联系管理员A10"),
    SVC_UPPER_UNSUPPORT(519, "上游服务器发生异常，请稍候再试"),
    SVC_UNAVAILABLE(520, "服务临时不可用，请稍后重试"),
    SVC_TIMEOUT(521, "服务超时，请稍后重试"),
    SVC_HTTP_UNSUPPORT(522, "服务器不支持您的 HTTP 版本，请联系"),
    SVC_UNKNOWN_ERR(523, "服务端发生错误"),
    DUPLICATE_USER(5007, "This user already exists.");

    public int getState() {
        return state;
    }

    public String getErrmsg() {
        return errmsg;
    }

    private final int state;
    private final String errmsg;

    StateMsg(int id, String message) {
        state = id;
        errmsg = message;
    }

    @Override
    public String toString() {
        return "StateMsg{" +
                "state=" + state +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
