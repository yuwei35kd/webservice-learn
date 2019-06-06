package com.example.webservice.server.service;

import com.example.webservice.server.domain.User;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebService(targetNamespace = "http://service.server.webservice.example.com/",
        endpointInterface = "com.example.webservice.server.service.UserService")
public class UserServiceImpl implements UserService {
    private Map<String, User> userMap = new HashMap<String, User>();

    public UserServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("101");
        user.setUsername("zhansan");
        user.setAge("20");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("102");
        user.setUsername("lisi");
        user.setAge("30");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("103");
        user.setUsername("wangwu");
        user.setAge("40");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);
    }

    @Override
    public User getUser(String userId) {
        User user = userMap.get(userId);
        return user;
    }

    @Override
    public ArrayList<User> getAllUser() {
        ArrayList<User> users = new ArrayList<>();
        userMap.forEach((key, value) -> {
            users.add(value);
        });
        return users;
    }

    @Override
    public User generateUser(User user) {
        if(user.getUpdateTime()==null){
            user.setUpdateTime(new Date());
        }
        return user;
    }

}
