package com.senyer.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@TableName("sys_user")//mybatis plus注解
@ApiModel//swagger注解
public class User {
    private int id;
    
    @ApiModelProperty("名字")//swagger注解
    private String name;
    
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("email")
    private String email;
    
    
    
    
    
	public User(int id, String name, Integer age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public User(String name, Integer age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
	}
    
}