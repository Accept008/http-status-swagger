package com.example.qztc.exception;

import cn.soundbus.library.core.exception.annotation.ExceptionResponseInfo;
import cn.soundbus.library.core.exception.general.GeneralException;
import org.springframework.http.HttpStatus;

/**
 * 自定义异常
 * 语义有误、参数有误相关
 *
*/

@ExceptionResponseInfo(
    errCode = "E40000",
    status = HttpStatus.BAD_REQUEST
)

public class BadException extends GeneralException {
    public static final String CODE = "E40000";
    public static final String MSG = "自定义400";
    public static final String DEV_MSG = "BadException";


    public BadException() {
        this((String)null);
    }

    public BadException(String message) {
        super(CODE, message);
    }

}
