package com.yuantu.project.model.dao;

import com.yuantu.project.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDao {

    @Autowired
    private UserInfoMapper userInfoMapper;



}
