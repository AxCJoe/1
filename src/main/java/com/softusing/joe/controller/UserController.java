package com.softusing.joe.controller;



import com.softusing.joe.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller
@RequestMapping("/api")

public class UserController {




    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getAllUser()
    {
        List<User> userList = new ArrayList<>();
        User user1 =new User();
        user1.setName("Andrew");
        user1.setAge(33);

        User user2 = new User();
        user2.setName("Melon");
        user2.setAge(18);
        userList.add(user2);
        userList.add(user1);

        return userList;
    }

}
