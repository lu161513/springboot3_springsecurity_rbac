package com.yuantu.project.mapper;

import com.yuantu.project.model.dto.ContentStructure;
import com.yuantu.project.model.entity.Permission;
import com.yuantu.project.model.entity.Role;
import org.springframework.stereotype.Repository;
import com.yuantu.project.model.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 根据用户名称查询该用户
     * @param phone - 用户名
     * @return User
     */
    UserInfo loadUserByUsername(String phone);

    List<Permission> selectPermissionsById(Serializable userId);

    List<Role> selectRolesById(Serializable userId);

    /**
     * 根据Id查询菜单
     *
     * @param userId -
     * @return -
     */
    List<ContentStructure> getContentStructuresByUserId(Serializable userId);

    boolean isExistsByUserPhone(String phone);
}
