package com.senyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senyer.config.GloableFileConfig;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/file")
@Api(tags = { "测试自定义属性" },value ="测试自定义属性"  )
public class PropertiesController {
	
	
    //@Value("${senyer.socket}")   // 也可以使用@Value直接注入属性值
    //private String i;
	
	
	
	//注入配置对象    Spring4.x以后，推荐使用构造函数的形式注入属性…  
    private final GloableFileConfig gloableFileConfig;
    @Autowired
    public PropertiesController(GloableFileConfig gloableFileConfig) {
        this.gloableFileConfig = gloableFileConfig;
    }
    
    
	@GetMapping("/path")
	public String getFilePath() {
		System.out.println("gloableFileConfig:"+gloableFileConfig.toString());
		return "文件路径："+gloableFileConfig.getPath();
	}
}
