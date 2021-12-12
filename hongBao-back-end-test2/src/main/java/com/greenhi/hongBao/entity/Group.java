package com.greenhi.hongBao.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Group对象", description="")
@TableName("user_group")  //group为关键字，关键字不能作为表名！！！
public class Group implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "群ID")
    @TableField("group_id")
    private String groupId;

    @ApiModelProperty(value = "群名称")
    @TableField("group_name")
    private String groupName;

    @ApiModelProperty(value = "群主ID")
    @TableField("admin_id")
    private String adminId;

    @ApiModelProperty(value = "群图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "群公告")
    @TableField("notice")
    private String notice;

    @ApiModelProperty(value = "群简介")
    @TableField("intro")
    private String intro;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String shareOne;

    private String shareTwo;

    private String shareThree;

    private String shareFour;
}
