package com.yuantu.project.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserRegisterDTO implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名长度不能超过20位")
    private String username;


    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phone;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码长度在6-18之间")
    private String password;

    @Email(message = "邮箱格式不合法")
    private String email;

    private LocalDateTime createTime;

}
