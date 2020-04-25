package com.example.qztc.dto;

import cn.soundbus.library.spring.web.api.response.SuccessResponse;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MsgResponseWrapper", description = "字符串")
public class MsgResponseWrapper extends SuccessResponse<String> {
}