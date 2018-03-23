package com.yuan.demo.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 类描述
 *
 * @author huang.wenchao
 */
@Controller
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);


    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        String result = "hello";
        for(int i = 0; i < 1000; i++) {
            logger.info("SampleController.hello() 请求, 请求参数是{}, result:{}", i, result);
        }
        logger.warn("测试 logger.warn()");
        return result;
    }


    @RequestMapping("/hello2")
    @ResponseBody
    public String hello2() {
        logger.error("测试 hello2() exception", new NullPointerException());
        return "exception";
    }

    @RequestMapping("/findUser/{userType}/{userNo}")
    @ResponseBody
    public String findUser( @PathVariable("userType") String userType,  @PathVariable("userNo") String userNo) {

        String result = "jack";
        logger.info("请求, 请求参数是{},{}, result:{}", userType, userNo, result);
        return result;
    }


}
