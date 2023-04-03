package com.yuantu.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuantu.project.model.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据userId查询其角色
     *
     * @param userId -
     * @return Set<Integer>
     */
    List<Long> selectRoleByUserId(Serializable userId);


    boolean deleteUserRoles(@Param("userRoles") List<UserRole> userRoles);

}
