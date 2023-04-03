package com.yuantu.project.config;


import com.yuantu.project.security.handler.CustomAccessDeniedHandler;
import com.yuantu.project.security.handler.CustomAuthorizationEntryPoint;
import com.yuantu.project.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity,
            CustomAuthorizationEntryPoint customAuthorizationEntryPoint,
            CustomAccessDeniedHandler customAccessDeniedHandler) throws Exception {
        return httpSecurity
                // 关闭csrf过滤器，因jwt不存储在cookie（jwt要存储在localStorage中，否则仍有csrf风险）
                .csrf().disable()
                // 基于token，不需要session
                .sessionManagement(o -> o.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 在 UsernamePasswordAuthenticationFilter 过滤器之前执行JWT认证过滤器
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(o -> {
                    // 处理未认证异常
                    o.authenticationEntryPoint(customAuthorizationEntryPoint);
                    // 处理未授权异常
                    o.accessDeniedHandler(customAccessDeniedHandler);
                })
                .build();
    }


    /**
     * 配置自定义UserDetailsService
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, UserServiceImpl userDetailsService) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 使用的密码比较方式，单参构造为加密强度(4-31)，默认10
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }


}
