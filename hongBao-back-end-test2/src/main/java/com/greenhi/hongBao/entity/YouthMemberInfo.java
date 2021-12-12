package com.greenhi.hongBao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="YouthMemberInfo对象", description="")
public class YouthMemberInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private String uid;

    @ApiModelProperty(value = "团员编号")
    private String mid;

    @ApiModelProperty(value = "所属团支部")
    private String youthLeagueBranch;

    @ApiModelProperty(value = "入团日期")
    private Date enterDate;

    @ApiModelProperty(value = "表现")
    private String performance;

    @ApiModelProperty(value = "应交团费")
    private Integer charge;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String shareOne;

    private String shareTwo;

    private String shareThree;

    private String shareFour;


}
