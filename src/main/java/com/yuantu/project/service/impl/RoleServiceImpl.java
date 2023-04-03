package com.yuantu.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuantu.project.exception.CustomException;
import com.yuantu.project.mapper.RoleMapper;
import com.yuantu.project.model.entity.Role;
import com.yuantu.project.model.entity.RolePermission;
import com.yuantu.project.service.IRolePermissionService;
import com.yuantu.project.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private IRolePermissionService iRolePermissionService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,
            CustomException.class})
    public boolean save(Role role, List<Long> permissionIds) {
        if (!save(role)) {
            throw new CustomException("创建角色失败");
        }
        List<RolePermission> rolePermissions = permissionIds.stream().map(permissionId->
                new RolePermission(role.getId(), permissionId)).collect(Collectors.toList());
        if (!iRolePermissionService.saveBatch(rolePermissions)){
            throw new CustomException("权限分配异常");
        }
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,
            CustomException.class})
    public boolean save(Role role) {
        if (roleMapper.isExistsByRoleName(role.getName())) {
            throw new CustomException("该角色已存在");
        }
        return super.save(role);
    }

    @Override
    public boolean saveBatch(Collection<Role> entityList) {
        return super.saveBatch(entityList);
    }
}
