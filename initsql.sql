create table yzjsxy.t_user_info
(
    id            int(11) auto_increment primary key comment '用户信息表id',
    username      varchar(30)                        null,
    password      varchar(255)                       null,
    phone         varchar(60)                        null,
    email         varchar(255)                       null,
    createTime    datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime    datetime                           null comment '更新时间',
    lastLoginTime datetime                           null,
    status        int      default 0                 null comment '用户状态：0有效，1无效',
    isDeleted     int      default 0                 null comment '是否删除：0未删除，1已经删除'
) engine = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '用户信息表';


create table yzjsxy.t_role_info
(
    id           int(11) auto_increment primary key comment '角色信息表id',
    name         varchar(30)                        null comment '角色名称',
    description  varchar(255)                       null comment '角色描述',
    status       int      default 0                 null comment '用户状态：0有效，1无效',
    createUserId int(11) comment '创建用户的id',
    isDeleted    int      default 0                 null comment '是否删除：0未删除，1已经删除',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime                           null comment '更新时间',
    remark       varchar(255)                       null

) engine = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '角色信息表';

create table yzjsxy.t_permission_info
(
    id                int(11) auto_increment primary key comment '权限表id',
    name              varchar(30)                        null comment '权限名称',
    permissionContent varchar(255)                       null comment '权限目录名称',
    permissionMenuUrl varchar(255)                       null comment '权限目录URL',
    permissionMenu    varchar(255)                       null comment '权限菜单名称',
    createTime        datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime        datetime                           null comment '更新时间',
    status            int      default 0                 null comment '用户状态：0有效，1无效',
    isDeleted         int      default 0                 null comment '是否删除：0未删除，1已经删除'
) engine = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '权限信息表';


create table yzjsxy.t_user_role_info
(
    id                int(11) auto_increment primary key comment '用户-角色关系表id',
    userId            int(11)  comment '用户id',
    roleId            int(11)  comment '角色id',
    createTime        datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime        datetime                           null comment '更新时间',
    status            int      default 0                 null comment '用户状态：0有效，1无效',
    isDeleted         int      default 0                 null comment '是否删除：0未删除，1已经删除'
) engine = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '用户角色关系表';


create table yzjsxy.t_role_permission_info
(
    id                int(11) auto_increment primary key comment '权限-角色关系表id',
    roleId            int(11)  comment '角色id',
    permissionId            int(11)  comment '权限id',
    updateTime        datetime                           null comment '更新时间',
    isDeleted         int      default 0                 null comment '是否删除：0未删除，1已经删除'
) engine = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '角色权限关系表';


