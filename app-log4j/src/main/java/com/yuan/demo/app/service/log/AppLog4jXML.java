package com.yuan.demo.app.service.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 类描述
 *
 * @author huang.wenchao
 */
public class AppLog4jXML {

    private static Logger LOG = LoggerFactory.getLogger(AppLog4jXML.class);

    public static void main(String[] args) {
        LOG.warn("AppLog4jXML log warn message");

        LOG.error("AppLog4jXML log error message");
    }
}
