package com.yuan.demo.app.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 类描述
 *
 * @author huang.wenchao
 */
public class AppLogback {

    private static Logger LOG = LoggerFactory.getLogger(AppLogback.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        LOG.debug("This is debug message.");
        // 记录info级别的信息
        LOG.info("This is info message.");
        // 记录error级别的信息
        LOG.error("This is error message.");
    }
}
