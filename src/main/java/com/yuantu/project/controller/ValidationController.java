package com.yuantu.project.controller;


import com.yuantu.project.common.util.ResponseResult;
import com.yuantu.project.model.entity.Permission;
import com.yuantu.project.service.IUserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/validation")
@Tag(name = "ValidationController", description = "权限验证相关")
public class ValidationController {

    @Autowired
    private IUserInfoService userInfoService;


    @GetMapping("/get_permimssions")
    @PreAuthorize("hasAuthority('SYSTEM_INDEX')")
    @Operation(summary = "获取所有权限的列表，仅仅admin可以使用")
    public ResponseResult getPermissions(Long userId) {
        List<Permission> permissions = userInfoService.selectPermissionsById(userId);
        return ResponseResult.success(permissions,"获取权限列表成功。");
    }

}
