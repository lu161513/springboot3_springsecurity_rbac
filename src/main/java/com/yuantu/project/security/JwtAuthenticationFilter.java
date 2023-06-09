package com.yuantu.project.security;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.yuantu.project.common.util.JwtUtils;
import com.yuantu.project.model.entity.UserInfo;
import com.yuantu.project.service.IUserInfoService;

import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
//    private CustomUserDetailsService customUserDetailsService;

    @Value("${jwt.token-prefix}")
    private String tokenPrefix;
    @Value("${jwt.token-name}")
    private String tokenName;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws ServletException, IOException {
        log.info("request uri: {}", req.getRequestURI());

        String s = req.getHeader(tokenName);
        // 存在token
        if (StringUtils.hasText(s) && s.startsWith(tokenPrefix)) {
            // 处理空白字符
            String t = s.trim().replaceAll("\\s+", " ");
            String token = t.substring(t.indexOf(" ") + 1);
            log.info("请求携带的token：{}", token);
            log.info("开始校验token");
            jwtUtils.verifyToken(token);
            log.info("token校验通过");

            // 获取token中的userId
            String userId = JWT.decode(token).getAudience().get(0);

            // 根据 userId 查询 username
            UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                    .select(UserInfo::getPhone)
                    .eq(UserInfo::getId, userId)
                    .eq(UserInfo::getStatus,0));
            Assert.notNull(userInfo, "用户不存在");

            // token合法性通过，开始校验有效性（根据用户名判断持有此token的用户的当前状态是否正常）
            UserInfo userDetails = userInfoService.loadUserByUsername(userInfo.getPhone());
            log.info("UserDetails:" + userDetails);
            log.info("Authorities:" + userDetails.getPermissions());

            // 表示当前访问系统的用户，封装了principal(UserInfo)、credentials、authorities(角色和权限)
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
                    (userDetails, null, userDetails.getAuthorities());

            // 将 request.getRemoteAddr() 保存到authentication的details属性中
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));

            // 参数为null时，访问需要鉴权的API会触发 InsufficientAuthenticationException（401）
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } else {
            log.info("请求未携带token");
        }

        filterChain.doFilter(req, resp);
    }

}
