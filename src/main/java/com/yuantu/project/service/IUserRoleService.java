package com.yuantu.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuantu.project.model.entity.UserRole;

import java.util.List;

public interface IUserRoleService extends IService<UserRole> {


    boolean updateRole(Long userId, List<Long> roleIds);


}
