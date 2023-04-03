package com.yuantu.project.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Menu对象", description = "菜单")
public class MenuVO {

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "URL路径")
    private String url;

}
