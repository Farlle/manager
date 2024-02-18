package com.example.exeption;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundException(NoHandlerFoundException ex) {
        // Логика обработки ошибки 404
        return "error-page"; // Перенаправление на страницу ошибки
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        // Логика обработки общей ошибки
        return "error-page"; // Перенаправление на страницу ошибки
    }
    @RequestMapping("/error")
    public String handle500() {
        return "error-page"; // возвращаем имя вашего шаблона для ошибки 500
    }

}
