package com.yuantu.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@ApiModel(value = "Permission",description = "权限")
@EqualsAndHashCode(callSuper = false)
@TableName("t_permission_info")
public class Permission extends Model<Permission> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "权限名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "权限目录名称")
    @TableField(value = "permissionContent")
    private String permissionContent;

    @ApiModelProperty(value = "权限目录URL")
    @TableField("permissionMenuUrl")
    private String permissionMenuUrl;

    @ApiModelProperty(value = "权限菜单名称")
    @TableField("permissionMenu")
    private String permissionMenu;

    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "updateTime",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "isDeleted")
    private Integer isDeleted;

    public Permission(String name, String permissionContent, String permissionMenuUrl, String permissionMenu) {
        this.name = name;
        this.permissionContent = permissionContent;
        this.permissionMenuUrl = permissionMenuUrl;
        this.permissionMenu = permissionMenu;
    }
}
