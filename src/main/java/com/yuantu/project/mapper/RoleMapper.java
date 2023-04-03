package com.yuantu.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuantu.project.model.entity.Role;

import java.io.Serializable;

public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据角色Id查询是否有该记录
     *
     * @param roleId - 角色Id
     * @return - boolean
     */
    boolean isExistsByRoleId(Serializable roleId);

    /**
     * 根据角色名称查询是否有该记录
     * @param roleName - 角色名称
     * @return - boolean
     */
    boolean isExistsByRoleName(String roleName);


}
