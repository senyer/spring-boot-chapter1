package com.senyer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senyer.entity.User;

import io.swagger.annotations.Api;

/*
 * 	测试日志记录功能
 */        
@RestController
@RequestMapping("/log")
@Api(tags = { "测试日志" },value ="测试日志"  )
public class LogController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/login")
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        Map<String,Object> map =new HashMap<String,Object>();
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        if(!name.equals("") && age!=""){
            User user =new User(name,Integer.valueOf(age));
            request.getSession().setAttribute("user",user);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
    }
}
