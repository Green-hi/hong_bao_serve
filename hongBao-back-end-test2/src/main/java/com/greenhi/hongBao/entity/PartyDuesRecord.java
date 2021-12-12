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
@ApiModel(value="PartyDuesRecord对象", description="")
@TableName("party_dues_record")
public class PartyDuesRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "党员编号")
    private String mid;

    @ApiModelProperty(value = "缴费月份（xx-xx）")
    private String month;

    @ApiModelProperty(value = "缴费金额")
    private Integer amount;

    @ApiModelProperty(value = "缴费方式")
    private String payWay;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String shareOne;

    private String shareTwo;

    private String shareThree;

    private String shareFour;

    @TableField(exist = false)
    private String branchName;
}
