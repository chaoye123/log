package com.yuan.demo.app.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * org.apache.commons.logging.getFactory()加载过程
 *
 * 1、从vm系统属性org.apache.commons.logging.LogFactory
 * 2、使用SPI服务发现机制，发现org.apache.commons.logging.LogFactory的实现
 * 3、查找classpath根目录commons-logging.properties的org.apache.commons.logging.LogFactory属性是否指定factory实现
 * 4、使用默认factory实现，org.apache.commons.logging.impl.LogFactoryImpl
 *
 * @author huang.wenchao
 */
public class AppJCL {

    private static Log log = LogFactory.getLog(AppJCL.class);

    public void log() {
        log.debug("Debug info.");
        log.info("Info info");
        log.warn("Warn info");
        log.error("Error info");
        log.fatal("Fatal info");
    }

    public static void main(String[] args) {
        AppJCL jcl = new AppJCL();
        jcl.log();
    }
}
