package com.example.qztc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "UserResult", description = "用户信息消息体")
public class UserResult implements Serializable {
    @ApiModelProperty(value = "userId", notes = "用户ID")
    private String userId;

    @ApiModelProperty(value = "userName", notes = "用户名称")
    private String userName;

    @ApiModelProperty(value = "phone", notes = "电话")
    private String phone;
}
