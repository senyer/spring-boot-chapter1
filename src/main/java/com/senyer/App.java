package com.senyer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.battcn.swagger.annotation.EnableSwagger2Doc;

@SpringBootApplication
@MapperScan("com.senyer.mapper")//最好在这里做统一扫描，不然在每个mapper接口文件加上@Mapper很麻烦
//@EnableSwagger2Doc  //主函数需要添加@EnableSwagger2Doc注解，来开启swagger功能     （此注解适用别人自定义封装好的swagger 的jar）
@EnableAsync	//允许程序执行@Async注解实现异步调用
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
