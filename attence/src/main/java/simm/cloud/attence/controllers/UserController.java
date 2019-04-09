package simm.cloud.attence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import simm.cloud.attence.mapper.UserMapper;
import simm.cloud.attence.model.User;
import simm.cloud.attence.service.HelloService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    HelloService helloService;
    @RequestMapping("/list")
    public List<User> getList(){
        List<User> users = userMapper.selectAll();
        return users;
    }
    @RequestMapping("/say")
    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}
