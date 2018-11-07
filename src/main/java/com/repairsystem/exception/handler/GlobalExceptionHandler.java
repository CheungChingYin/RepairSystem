package com.repairsystem.exception.handler;

import com.repairsystem.exception.AdministratorIdIsNullException;
import com.repairsystem.utils.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CheungChingYin
 * @date 2018/11/6
 * @time 22:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdministratorIdIsNullException.class)
    @ResponseBody
    public JsonResult administratorIdIsNullExceptionHandler(){
        return JsonResult.errorMsg("传入的管理员ID为空");
    }
}
