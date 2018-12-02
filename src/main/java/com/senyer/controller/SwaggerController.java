package com.senyer.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.senyer.entity.User;
import com.senyer.mapper.UserMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Api( description = "用户管理", value = "用户管理")
public class SwaggerController {

    private  final Logger log = LoggerFactory.getLogger(SwaggerController.class);
    @Autowired
	private UserMapper userMapper;

    @GetMapping()
    @ApiOperation(value = "条件查询（DONE）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = ApiDataType.INT, paramType = ApiParamType.QUERY),
    })
    public List<User> query(String username, int age) {
        log.info("多个参数用  @ApiImplicitParams");
        return userMapper.selectList(null);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "主键查询（DONE）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH),
    })
    public User get(@PathVariable Long id) {
        log.info("单个参数用  @ApiImplicitParam");
        return userMapper.selectById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户（DONE）")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH)
    public void delete(@PathVariable Long id) {
        log.info("单个参数用 ApiImplicitParam");
    }

    @PostMapping
    @ApiOperation(value = "添加用户（DONE）")
    public User post(@RequestBody User user) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
        return user;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改用户（DONE）")
    public void put(@PathVariable Long id, @RequestBody User user) {
        log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
    }
}