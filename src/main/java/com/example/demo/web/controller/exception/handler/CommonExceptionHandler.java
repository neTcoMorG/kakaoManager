package com.example.demo.web.controller.exception.handler;

import com.example.demo.web.controller.exception.custom.PermissionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class CommonExceptionHandler {

    /*
        서비스 계층에서 발생할 수 있는 권한 예외를 처리하기 위한 핸들러입니다.
        service -> isValid() 에서 발생됨
    */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(PermissionException.class)
    public void permissionExceptionHandler (RuntimeException ex) { }

    /*
        서비스 계층에서 없는 리소스 작업에 대한 예외를 처리하기 위한 핸들러입니다
        service -> orElseThrow 에서 발생됨
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public void noSuchElementExceptionHandler (RuntimeException ex) { }
}
