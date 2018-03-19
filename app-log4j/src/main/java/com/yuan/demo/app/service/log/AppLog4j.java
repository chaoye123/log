package com.yuan.demo.app.service.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * log4j 1.x 版本
 * 2015年5月，Apache宣布Log4J 1.x 停止更新。最新版为1.2.17。
 *
 * @author huang.wenchao
 */
public class AppLog4j {

    private static Logger LOG = LoggerFactory.getLogger(AppLog4j.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        LOG.debug("This is debug message.");
        // 记录info级别的信息
        LOG.info("This is info message.");
        // 记录error级别的信息
        LOG.error("This is error message.");
    }
}
