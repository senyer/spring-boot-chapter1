package com.senyer;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.senyer.entity.User;
import com.senyer.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
       /* System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);*/
    }

    @Test
    public void testInsert() {
       /* System.out.println(("----- Insert ------"));
        User user=new User();
        user.setName("森1");
        user.setAge(18);
        user.setEmail("123@qq.com");
        userMapper.insert(user);
        List<User> userList = userMapper.selectList(null);
        //Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);*/
    }
    
    
    

}