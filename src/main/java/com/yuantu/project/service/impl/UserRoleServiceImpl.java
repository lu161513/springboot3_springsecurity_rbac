package com.yuantu.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuantu.project.exception.CustomException;
import com.yuantu.project.mapper.UserRoleMapper;
import com.yuantu.project.model.entity.UserRole;
import com.yuantu.project.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class,
            CustomException.class})
    public boolean updateRole(Long userId, List<Long> roleIds) {
        List<Long> oldRoleIds = userRoleMapper.selectRoleByUserId(userId);
        List<UserRole> oldUserRoles = oldRoleIds.stream().filter(roleId -> !roleIds.contains(roleId))
                .map(id -> new UserRole(userId, id)).collect(Collectors.toList());
        if (oldUserRoles.size() > 0) {
            if (!userRoleMapper.deleteUserRoles(oldUserRoles)) {
                throw new CustomException("更新角色错误：删除");
            }
        }

        List<UserRole> newUserRoles = roleIds.stream().filter(roleId -> !oldRoleIds.contains(roleId))
                .map(id -> new UserRole(userId, id)).collect(Collectors.toList());
        if (newUserRoles.size() > 0) {
            if (!saveBatch(newUserRoles)) {
                throw new CustomException("更新角色错误：添加");
            }
        }
        return true;
    }

    @Override
    public boolean save(UserRole userRole) {
        return super.save(userRole.setUpdateTime(new Date().toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime()).setIsDeleted(0));
    }

    @Override
    public boolean saveBatch(Collection<UserRole> entityList) {
        return super.saveBatch(entityList.stream().map(permission ->
                        permission.setUpdateTime(new Date().toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime()).setIsDeleted(0))
                .collect(Collectors.toList()));
    }

}
