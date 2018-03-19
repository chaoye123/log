//package com.yuan.demo.app.logback.utils;
//
//
//import java.util.Collections;
//import java.util.Set;
//import org.slf4j.Logger;
//import org.slf4j.MDC;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.alibaba.druid.pool.GetConnectionTimeoutException;
//import com.mei.common.Param;
//import com.mei.jdbc.exception.SqlExecuteException;
//import com.mei.util.SystemInfo;
//import com.xunlei.netty.httpserver.component.XLContextAttachment;
//import com.xunlei.netty.httpserver.component.XLHttpRequest;
//import com.xunlei.netty.httpserver.component.XLHttpResponse;
//import com.xunlei.netty.httpserver.util.AntiDos;
//import com.xunlei.netty.httpserver.util.HttpServerConfig;
//import com.xunlei.spring.Config;
//import com.xunlei.util.Log;
//import com.xunlei.util.StringTools;
//
///**
// * @author ZengDong
// * @since 2011-3-18 下午06:19:53
// */
//public abstract class TextResponseHandler implements Handler {
//
//    public static final Logger log = Log.getLogger();
//
//    /** 为了防止报错邮件发太多，这里可以加条件予以限制，如设置1,60表示60s内只报告1条异常消息 */
//    //private static AntiDos logMailLimit = new AntiDos(1, 60).initSweeper();
//
//    @Autowired
//    protected HttpServerConfig serverConfig;
//
//    protected String responseReturnNullInfo = "cmd return null";
//
//    @Autowired
//    protected TextResponseHandlerManager textResponseHandlerManager;
//
//    /** 不计入日志的异常列表 */
//    @Config(resetable = true)
//    protected Set<String> logThrowableIgnoreList = Collections.emptySet();
//
//    public static void logError(final String title, final String content, final Object... args) {
//        if (null != logMailLimit) {
//            if (!logMailLimit.visit(title)) { // 发现如果标题已经报告过了，一定时间内就不再报告
//                return;
//            }
//        }
//        // 为了能在报错邮件中区分是什么版本的客户端，增加了读取MDC版本的机制，数据写入在CmdMapperDispatcher类中处理
//        String v = MDC.get(Param.version);
//        String prefix = "";
//        if (StringTools.isNotEmpty(v) && v.contains("beta")) {
//            prefix = "(测试)";
//        }
//        MDC.put("mailTitle", prefix + SystemInfo.RUN_APP_NAME + title);
//        log.error(prefix + title + "\n" + content, args);
//    }
//
//    /**
//     * 处理当前的attach中的response具体包体
//     *
//     * @return 非null 表示处理完成,null 表示不处理
//     */
//    public abstract String buildContentString(XLContextAttachment attach, Object cmdReturnObj);
//
//    public abstract Object handleThrowable(XLContextAttachment attach, Throwable ex) throws Exception;
//
//    public void logThrowable(final XLContextAttachment attach, final XLHttpRequest request, XLHttpResponse response, final Throwable ex) {
//        response.setStatus(HttpResponseStatus.INTERNAL_SERVER_ERROR); // 如果是未知错误则返回500
//        String name = ex.getClass().getName();
//        String title = ex.getClass().getSimpleName();
//
//        // 2016-10-10 由于阿里云DRDS抽风时，会连续爆非常多的异常，都是数据库连接的问题，这里单独提出来处理报告
//        if (ex instanceof SqlExecuteException) {
//            Throwable cause = ex.getCause();
//            if (cause instanceof GetConnectionTimeoutException) {
//                name = cause.getClass().getName();
//                title = cause.getClass().getSimpleName();
//            }
//        }
//        if (logThrowableIgnoreList.contains(name)) { // 如果发现是无需报告的异常，则不进入发邮件流程
//            return;
//        }
//        if (null != logMailLimit) {
//            if (!logMailLimit.visit(name)) { // 发现如果异常已经报告过了，一定时间内就不再报告（不重复报告同一类型的异常，避免发太多邮件）
//                return;
//            }
//        }
//        logError(title + ":" + request.getPath(), "\n{}", request.getDetailInfo(), ex);
//    }
//}
