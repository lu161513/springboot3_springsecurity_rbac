package com.yuantu.project.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Content对象", description = "目录Content对象")
public class ContentVO {
    @ApiModelProperty(value = "目录名称")
    private String name;

    @ApiModelProperty(value = "菜单列表")
    private List<MenuVO> menuList;

    public ContentVO(String name) {
        this.name = name;
    }

}
