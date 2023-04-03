package com.yuantu.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuantu.project.model.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据权限Id查询是否有该记录
     *
     * @param permissionId - 权限Id
     * @return - boolean
     */
    boolean isExistsByPermissionId(Serializable permissionId);


    /**
     * 根据权限名称或权限菜单查询是否有该记录
     * @param permissionName - 权限名称（可以为null）
     * @param permissionMenu - 权限名称（可以为null）
     * @return boolean
     */
    boolean isExistsByPermissionNameOrMenu(@Param("permissionName") String permissionName, @Param("permissionMenu") String permissionMenu);

}
