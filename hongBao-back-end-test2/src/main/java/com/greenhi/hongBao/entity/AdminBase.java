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
@TableName("admin_base")
@ApiModel(value="AdminBase对象", description="")
public class AdminBase implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "管理员账号")
    @TableField("aid")
    private String aid;

    @ApiModelProperty(value = "管理员昵称")
    @TableField("admin_name")
    private String adminName;

    @ApiModelProperty(value = "管理员密码")
    @TableField("password")
    private String password;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField("share_one")
    private String shareOne;

    @TableField("share_two")
    private String shareTwo;

    @TableField("share_three")
    private String shareThree;

    @TableField("share_four")
    private String shareFour;

}
