package com.example.qztc.controller;

import cn.soundbus.library.core.exception.authorization.UnauthorizedException;
import cn.soundbus.library.spring.web.api.response.RestErrorResponse;
import cn.soundbus.library.spring.web.api.response.SuccessResponse;
import com.example.qztc.dto.MsgResponseWrapper;
import com.example.qztc.dto.UserResponseWrapper;
import com.example.qztc.dto.UserResult;
import com.example.qztc.exception.BadException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "测试用")
public class LabController {

    @GetMapping("/200/str")
    @ApiOperation(
            value = "200请求,payload为字符串测试",
            notes = "200请求,payload为字符串测试",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应", response = MsgResponseWrapper.class),
            @ApiResponse(code = 400, message = "传参错误响应", response = RestErrorResponse.class),
            @ApiResponse(code = 500, message = "服务器内部错误", response = RestErrorResponse.class),
    })
    public ResponseEntity<SuccessResponse> req200(String pa){
        String result = "pa is" + pa;
        SuccessResponse resp = SuccessResponse.buildOkResponse();
        resp.setMessage("获取成功");
        resp.setPayload(result);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/200/object")
    @ApiOperation(
            value = "200请求,payload为对象测试",
            notes = "200请求,payload为对象测试",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应", response = UserResponseWrapper.class),
            @ApiResponse(code = 400, message = "传参错误响应", response = RestErrorResponse.class),
            @ApiResponse(code = 500, message = "服务器内部错误", response = RestErrorResponse.class),
    })
    public ResponseEntity<SuccessResponse> reqOb200(String pa){
        UserResult result = new UserResult();
        result.setUserId("101");
        result.setUserName("用户101");
        result.setPhone("9527");
        SuccessResponse resp = SuccessResponse.buildOkResponse();
        resp.setMessage("获取成功");
        resp.setPayload(result);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/400")
    @ApiOperation(
            value = "400请求测试",
            notes = "400请求测试",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应", response = MsgResponseWrapper.class),
            @ApiResponse(code = 400, message = "传参错误响应", response = RestErrorResponse.class),
            @ApiResponse(code = 500, message = "服务器内部错误", response = RestErrorResponse.class),
    })
    public ResponseEntity<SuccessResponse> req400(String pa){
        if(true){
            throw new BadException("400参数异常");
        }
        String result = "pa is " + pa;
        SuccessResponse resp = SuccessResponse.buildOkResponse();
        resp.setMessage("获取成功");
        resp.setPayload(result);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/401")
    @ApiOperation(
            value = "401请求测试",
            notes = "401请求测试",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应", response = MsgResponseWrapper.class),
            @ApiResponse(code = 400, message = "传参错误响应", response = RestErrorResponse.class),
            @ApiResponse(code = 500, message = "服务器内部错误", response = RestErrorResponse.class),
    })
    public ResponseEntity<SuccessResponse> req401(String pa){
        if(true){
            throw new UnauthorizedException("401未授权异常");
        }
        String result = "pa is " + pa;
        SuccessResponse resp = SuccessResponse.buildOkResponse();
        resp.setPayload(result);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/500")
    @ApiOperation(
            value = "500请求测试",
            notes = "500请求测试",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应", response = MsgResponseWrapper.class),
            @ApiResponse(code = 400, message = "传参错误响应", response = RestErrorResponse.class),
            @ApiResponse(code = 500, message = "服务器内部错误", response = RestErrorResponse.class),
    })
    public ResponseEntity<SuccessResponse> req500(String pa){
        int i = 1/0;
        SuccessResponse resp = SuccessResponse.buildOkResponse();
        resp.setPayload(pa);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/exception")
    @ApiOperation(
            value = "exception请求测试",
            notes = "exception请求测试",
            produces = "application/json"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功响应", response = MsgResponseWrapper.class),
            @ApiResponse(code = 400, message = "传参错误响应", response = RestErrorResponse.class),
            @ApiResponse(code = 500, message = "服务器内部错误", response = RestErrorResponse.class),
    })
    public ResponseEntity<SuccessResponse> serverException(String pa){
        try{
            int i = 1/0;
        }catch (Exception e){
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
