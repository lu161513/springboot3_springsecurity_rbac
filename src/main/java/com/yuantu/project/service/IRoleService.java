package com.yuantu.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuantu.project.model.entity.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {

    boolean save(Role role, List<Long> permissionIds);

}
