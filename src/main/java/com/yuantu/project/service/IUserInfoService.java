package com.yuantu.project.service;

import com.yuantu.project.common.util.ResponseResult;
import com.yuantu.project.model.dto.ContentVO;
import com.yuantu.project.model.dto.LoginDTO;
import com.yuantu.project.model.dto.UserInfoDTO;
import com.yuantu.project.model.dto.UserRegisterDTO;
import com.yuantu.project.model.entity.Permission;
import com.yuantu.project.model.entity.Role;
import com.yuantu.project.model.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;


public interface IUserInfoService extends IService<UserInfo>{


    ResponseResult<UserInfoDTO> login(LoginDTO loginDTO);

    ResponseResult<UserRegisterDTO> register(UserRegisterDTO userRegisterDTO);

    /**
     * 根据用户名称查询该用户
     * @param phone - 用户名、手机号之类
     * @return User
     */
    UserInfo loadUserByUsername(String phone);

    /**
     * 根据Id查询对应权限
     * @param userId -
     * @return List<String>
     */
    List<Permission> selectPermissionsById(Serializable userId);

    /**
     * 根据Id查询对应的角色
     * @param userId -
     * @return - List<Role>
     */
    List<Role> selectRolesById(Serializable userId);


    /**
     * 根据用户Id查询对应的目录结构
     * @param userId -
     * @return List<Content>
     */
    List<ContentVO> getContentsById(Serializable userId);

    /**
     * 根据用户查询对应的目录结构
     * @param user -
     * @return List<Content>
     */
    List<ContentVO> getContentsByUser(UserInfo user);

    /**
     * 创建用户同时赋予其角色
     * @param user - 用户
     * @param roleIds - 角色Id
     * @return boolean
     */
    boolean save(UserInfo user, List<Long> roleIds);


}
