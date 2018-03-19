package com.yuan.demo.app.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * log4j 2.x
 *
 * 官网[https://logging.apache.org/log4j/2.x/]
 *
 *  https://logging.apache.org/log4j/2.x/manual/extending.html
 *
 * 其配置文件只能采用.xml, .json或者 .jsn。在默认情况下，系统选择configuration文件的优先级如下：（classpath为scr文件夹）
 *
 * classpath下名为 log4j-test.json 或者log4j-test.jsn文件
 * classpath下名为 log4j2-test.xml
 * classpath下名为 log4j.json 或者log4j.jsn文件
 * classpath下名为 log4j2.xml
 *
 * Log4j2.0基于LMAX Disruptor的异步日志在多线程环境下性能会远远优于Log4j 1.x和logback（官方数据是10倍以上）。
 *
 * @author huang.wenchao
 */
public class AppLog4j2 {

    private static Logger LOG = LoggerFactory.getLogger(AppLog4j2.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        LOG.debug("This is debug message.");
        // 记录info级别的信息
        LOG.info("This is info message.");
        // 记录error级别的信息
        LOG.error("This is error message.");
    }
}
