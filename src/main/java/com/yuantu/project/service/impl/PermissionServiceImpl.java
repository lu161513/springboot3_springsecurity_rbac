package com.yuantu.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuantu.project.exception.CustomException;
import com.yuantu.project.mapper.PermissionMapper;
import com.yuantu.project.model.entity.Permission;
import com.yuantu.project.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public boolean save(Permission permission) {
        boolean isExists = permissionMapper.isExistsByPermissionNameOrMenu(permission.getName(), permission.getPermissionMenu());
        if (isExists) {
            throw new CustomException("该权限已存在");
        }
        return super.save(permission);
    }


    @Override
    public boolean saveBatch(Collection<Permission> entityList) {
        return super.saveBatch(entityList);
    }
}
