package com.yuantu.project.controller;


import com.yuantu.project.common.util.ResponseResult;
import com.yuantu.project.model.dto.LoginDTO;
import com.yuantu.project.model.dto.UserRegisterDTO;
import com.yuantu.project.service.IUserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "UserController", description = "用户相关")
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public ResponseResult login(@Validated @RequestBody LoginDTO loginDTO) {
        return userInfoService.login(loginDTO);
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public ResponseResult register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        return userInfoService.register(userRegisterDTO);
    }

//    @PreAuthorize("isAuthenticated() and hasAuthority('SYSTEM_PERMISSION_ADD')")
    @PreAuthorize("isAuthenticated() and hasRole('ROLE_User')")
    @GetMapping("/authentication")
    public ResponseResult getAuthentication() {
        return ResponseResult.success(SecurityContextHolder.getContext().getAuthentication(), "当前正在访问系统的用户的详细信息");
    }






}
