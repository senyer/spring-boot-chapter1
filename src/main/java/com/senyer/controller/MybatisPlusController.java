package com.senyer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senyer.entity.User;
import com.senyer.mapper.UserMapper;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/mp")
@Api(tags = { "测试Mybatis plus" },value ="测试Mybatis plus"  )
public class MybatisPlusController {
	private  final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserMapper userMapper;

	@GetMapping("{id}")
	public User getUserOne(@PathVariable("id")String id){
		logger.debug("id:{}",id);
		User selectOne = userMapper.selectById(id);
		return selectOne;
	}
	
	@GetMapping("list")
	public List<User> getUser(){
		List<User> selectList = userMapper.selectList(null);
		return selectList;
	}
}
