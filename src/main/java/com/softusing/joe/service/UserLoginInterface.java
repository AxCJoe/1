package com.softusing.joe.service;

import com.softusing.joe.domain.UserLogin;
import com.softusing.joe.domain.UserLoginExample;
import com.softusing.joe.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserLoginInterface {

    int save(UserLogin userLogin);

    boolean login(UserLogin userLogin);

}
