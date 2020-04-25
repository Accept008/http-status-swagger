package com.example.qztc.dto;

import cn.soundbus.library.spring.web.api.response.SuccessResponse;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "UserResponseWrapper", description = "用户信息消息体封装")
public class UserResponseWrapper extends SuccessResponse<UserResult> {
}
