package com.yuantu.project.model.role;

import org.springframework.security.core.GrantedAuthority;

public class AdminRole implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return null;
    }
}
