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
@ApiModel(value="PartyBranch对象", description="")
@TableName("party_branch")
public class PartyBranch implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "党支部ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "党支部名称")
    private String branchName;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "备用")
    private String shareOne;

    @ApiModelProperty(value = "备用")
    private String shareTwo;

    @ApiModelProperty(value = "备用")
    private String shareThree;

    @ApiModelProperty(value = "备用")
    private String shareFour;


}
