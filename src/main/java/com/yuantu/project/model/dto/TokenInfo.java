package com.yuantu.project.model.dto;

import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

@Data
public class TokenInfo implements Serializable {
    private String tokenName;
    private String tokenPrefix;
    private String tokenValue;
    /**
     * 当前登录者的 token 剩余有效时间（单位：秒）
     */
    private Long tokenTimeout;
    private Long loginId;
//    private Collection<? extends GrantedAuthority> authorities;
    private String loginDevice;

}
