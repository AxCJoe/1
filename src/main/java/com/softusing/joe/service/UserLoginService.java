package com.softusing.joe.service;


import com.softusing.joe.domain.Book;
import com.softusing.joe.domain.BookExample;
import com.softusing.joe.domain.UserLogin;
import com.softusing.joe.domain.UserLoginExample;
import com.softusing.joe.form.UserForm;
import com.softusing.joe.mapper.BookMapper;
import com.softusing.joe.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginService implements UserLoginInterface {

    @Autowired
    private UserLoginMapper userLoginMapper;

    public int save(UserLogin userLogin) {
        return userLoginMapper.insert(userLogin);
    }

    public int update(UserLogin userLogin) {
        return userLoginMapper.updateByPrimaryKey(userLogin);
    }

    public int delete(long id) {
        return userLoginMapper.deleteByPrimaryKey(id);
    }

    public UserLogin findById(long id) {
        return userLoginMapper.selectByPrimaryKey(id);
    }

    List<UserLogin> findByUsername(String username) {
        return userLoginMapper.selectByUsername(username);
    }

    List<UserLogin> findByPassword(String password) {

        return userLoginMapper.selectByUserPassword(password);
    }

    public boolean login(UserLogin userLogin) {
        String name = userLogin.getUsername();
        String password = userLogin.getPassword();
        List<UserLogin> userLoginList = userLoginMapper.selectByUsername(name);
        if (userLoginList == null) {
            return false;
        } else {
            for (int i = 0; i < userLoginList.size(); i++) {
                if (userLoginList.get(i).getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}