package com.senyer.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/thy")
@Api(tags = { "测试thymeleaf" },value ="测试thymeleaf")
public class ThymeleafController {
	
	@RequestMapping("/hello")
	public String hello(Map<String, Object> map) {
		map.put("name", "森森");
		return "index";
	}
}
