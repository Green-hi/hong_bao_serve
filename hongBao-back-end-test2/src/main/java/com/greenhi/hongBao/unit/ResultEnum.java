package com.greenhi.hongBao.unit;

public enum ResultEnum {

    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(100,"成功"),
    USER_IS_EXISTS(102,"用户已存在"),
    USER_NOT_EXISTS(104,"用户不存在"),
    DATA_IS_DEFECT(6,"数据缺失"),
    PASSWORD_ERROR(103,"密码错误"),
    DUE_IS_PAYED(105,"本月已缴费"),
    RUNWAY_NOT_EXISTS(201,"跑道不存在"),
    DATA_NOT_EXISTS(301,"数据不存在"),
    DATA_IS_EXISTS(302,"数据已存在"),
    ORDER_NOT_EXISTS(401,"订单不存在"),
    FILE_NOT_EXISTS(501,"文件不能为空"),
    FILE_NOT_UPLOADS(501,"文件上传失败"),
    FILE_IS_EXISTS(502,"文件已存在"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
