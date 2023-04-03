package com.yuantu.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuantu.project.mapper.RolePermissionMapper;
import com.yuantu.project.model.entity.RolePermission;
import com.yuantu.project.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;


    @Override
    public boolean save(RolePermission entity) {
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<RolePermission> entityList) {
        return super.saveBatch(entityList);
    }


}
