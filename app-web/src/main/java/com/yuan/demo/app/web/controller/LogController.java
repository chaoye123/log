package com.yuan.demo.app.web.controller;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yuan.demo.app.web.utils.FixSizeMemAppender;
import com.yuan.demo.app.web.utils.FixSizeMemAppender.FixSizeLog;
/**
 * 类描述
 *
 * @author huang.wenchao
 */
@Controller
public class LogController {


    @RequestMapping("/log/show")
    @ResponseBody
    public Object getAllLog() throws Exception {
        StringBuilder sb = new StringBuilder(new java.util.Date().toString() + "</br>");
        while (true) {
            try {
                StringBuilder s = new StringBuilder();
                Collection<FixSizeLog> fixSizeLogs = FixSizeMemAppender.getAllLog();
                for (FixSizeLog log : fixSizeLogs) {
                   s.append("[" + log.getLoggerName() + "]</br>" + log + "</br>");
                }
                sb.append(s);
                break;
            } catch (ConcurrentModificationException e) {
            }
        }
        return sb.toString();
    }
}
